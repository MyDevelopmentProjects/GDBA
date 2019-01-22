function hexToRgb(hex){
  var c;
  if(/^#([A-Fa-f0-9]{3}){1,2}$/.test(hex)){
      c= hex.substring(1).split('');
      if(c.length== 3){
          c= [c[0], c[0], c[1], c[1], c[2], c[2]];
      }
      c= '0x'+c.join('');
      return 'rgb('+[(c>>16)&255, (c>>8)&255, c&255].join(',')+')';
  }
  throw new Error('Bad Hex');
}

function getContrast(rgb) {

  if(!rgb) return 'black';

  var className = '';

  if(typeof rgb === 'string') {
    rgb = hexToRgb(rgb).split('(')[1].split(')')[0].split(',').map(function(a) {
      return parseInt(a);
    });
  }

  var o = Math.round(((parseInt(rgb[0]) * 299) +
                      (parseInt(rgb[1]) * 587) +
                      (parseInt(rgb[2]) * 114)) / 1000);

  if(o > 125) {
    return 'black';
  } else {
    return 'white';
  }
}

function ColorfulSlider(rootNode) {
  var that = this;
  this.switchInterval;
  this.el = rootNode;
  this.slideDelay = 6000; //ms
  this.activeSlide = 0; //active slide index

  this.rotator = this.el.querySelector('.banner-rotator');
  this.slides = Array.prototype.slice.call(this.rotator.querySelectorAll('.banner-rotator__slide'));
  this.sectionTitle = this.el.querySelector('.section__title');

  this.bulletCon = this.el.querySelector('.bullet-list');
  this.bullets = [];
  this.lrControls = this.el.querySelector('.lr-controls');

  this.setSlide(this.activeSlide);

  //drop switchers
  this.slides.forEach(function(slide, i) {
    var b = document.createElement('li');
    b.classList.add('bullet-list__item');

    if(i == that.activeSlide) {
      b.classList.add('active');
    }

    b.addEventListener('click', function() {
      that.setSlide(i);
      if(this.activeSlide == i) {
        b.classList.add('active');
      }
      that.run();
    });

    that.bullets.push(b);
    that.bulletCon.appendChild(b);
  });

  // start automatic interval
  this.run();

  //attach click handlers to left/right arrows

  this.lrControls.querySelector('[data-back]').addEventListener('click', function(e) {

    if(!e.target.classList.contains('active')) return;

    if(that.activeSlide > 0) {
      that.activeSlide--;
    } else {
      e.target.classList.remove('active');
    }

    that.setSlide(that.activeSlide);
    that.run();
  });

  this.lrControls.querySelector('[data-next]').addEventListener('click', function(e) {

    if(!e.target.classList.contains('active')) return;

    if(that.activeSlide < that.slides.length - 1) {
      that.activeSlide++;
    } else {
      e.target.classList.remove('active');
    }

    that.setSlide(that.activeSlide);
    that.run();
  });

}

ColorfulSlider.prototype.run = function() {
  var that = this;

  if(this.interval) {
    clearInterval(this.interval);
  }

  this.interval = setInterval(function() {

    //go forward
    if(that.activeSlide < that.slides.length - 1) {
      that.activeSlide++;
    } else {
      that.activeSlide = 0;
    }

    that.setSlide(that.activeSlide);

  }, this.slideDelay);
}

ColorfulSlider.prototype.fadeOut = function(el) {
  el.classList.remove('banner-rotator__slide--fadein');
  el.classList.add('banner-rotator__slide--fadeout');
  setTimeout(function() {
    el.classList.remove('banner-rotator__slide--show');
  }, 100);
}

ColorfulSlider.prototype.fadeIn = function(el) {
  el.classList.remove('banner-rotator__slide--fadeout');
  el.classList.add('banner-rotator__slide--show');
  el.classList.add('banner-rotator__slide--fadein');
}

ColorfulSlider.prototype.hide = function(el) {
  el.classList.remove('banner-rotator__slide--fadein');
  el.classList.remove('banner-rotator__slide--fadeout');
  el.classList.remove('banner-rotator__slide--show');
}

ColorfulSlider.prototype.setSlide = function(slideIdx) {
  var that = this;

  this.slides.forEach(function(slide, index) {
    if(index == slideIdx) {
      that.fadeIn(slide);

      if(slide.getAttribute('data-color')) {
        that.el.setAttribute('style', 'background-color: #' + slide.getAttribute('data-color'));

        that.sectionTitle.classList.remove('section__title--white');
        that.sectionTitle.classList.remove('section__title--black');
        that.sectionTitle.classList.add('section__title--' + getContrast('#' + slide.getAttribute('data-color')));
      }

    } else {
      that.hide(slide);
    }
  });

  that.activeSlide = slideIdx;

  if(that.activeSlide > 0) {
    that.lrControls.querySelector('[data-back]').classList.add('active');
  } else {
    that.lrControls.querySelector('[data-back]').classList.remove('active');
  }

  if(that.activeSlide < that.slides.length - 1) {
    this.lrControls.querySelector('[data-next]').classList.add('active');
  } else {
    this.lrControls.querySelector('[data-next]').classList.remove('active');
  }

  that.bullets.forEach(function(b, i) {
    if(i == slideIdx) {
      b.classList.add('active');
    } else {
      b.classList.remove('active');
    }
  });


}

function SimpleCarousel(el) {
 var that = this;
 this.el = el;
 this.id = el.getAttribute('id');
 this.activeSlide = 0;
 this.slideNodes = el.parentNode.querySelectorAll('[data-simple-carousel] > div');
 this.slides = Array.prototype.slice.call(this.slideNodes);
 this.controls = this.el.parentNode.querySelector('[data-simple-controls]');
 this.arrows = document.querySelector('[data-controls-for="' + this.id + '"]');

 this.arrows.querySelector('[data-prev]').addEventListener('click', function() {
   if(that.activeSlide > 0) {
     that.setSlide(that.activeSlide - 1);
   }
 });

 this.arrows.querySelector('[data-next]').addEventListener('click', function() {
   if(that.activeSlide < that.slides.length - 1) {
     that.setSlide(that.activeSlide + 1);
   }
 });

 for (var i = 0; i < this.slides.length; i++) {

   var b = document.createElement('li');
   b.classList.add('bullet-list__item');
   b.setAttribute('data-to', i);

   if(i == that.activeSlide) {
     b.classList.add('active');
   }

   b.addEventListener('click', function(e) {
     Array.prototype.forEach.call(that.controls.querySelectorAll('li'), function(elem) {
       elem.classList.remove('active');
     });

     that.setSlide(parseInt(e.target.getAttribute('data-to')));
   });

   this.controls.appendChild(b);
 }

 this.setSlide(0);
}

SimpleCarousel.prototype.hideSlide = function(i) {
  var that = this;
  this.slides[i].classList.remove('fadein');
  this.slides[i].classList.add('fadeout');

  setTimeout(function() {
    that.slides[i].classList.remove('show');
  }, 80);
}

SimpleCarousel.prototype.showSlide = function(i) {
  var that = this;
  setTimeout(function() {
    that.slides[i].classList.remove('fadeout');
    that.slides[i].classList.add('show');
    that.slides[i].classList.add('fadein');
  }, 80);
}

SimpleCarousel.prototype.setSlide = function(slideIdx) {
  var that = this;

  this.activeSlide = slideIdx;

  Array.prototype.forEach.call(that.controls.querySelectorAll('li'), function(elem) {
    if(elem.getAttribute('data-to') == that.activeSlide) {
      elem.classList.add('active');
    } else {
     elem.classList.remove('active');
    }
  });

  if(this.slides.length > 1 && this.activeSlide != (this.slides.length - 1)) {
    that.arrows.querySelector('[data-next]').classList.add('active');
  } else {
    that.arrows.querySelector('[data-next]').classList.remove('active');
  }

  if(this.slides.length > 1 && this.activeSlide > 0) {
    that.arrows.querySelector('[data-prev]').classList.add('active');
  } else {
    that.arrows.querySelector('[data-prev]').classList.remove('active');
  }

  for (var i = 0; i < this.slides.length; i++) {
    if (i === this.activeSlide) {
      that.showSlide(i);
    } else {
      that.hideSlide(i);
    }
  }

}


//Load Main page

function loadMainPage() {
    //main

    tns({
        container: '.main-slider',
        mode: 'gallery',
        items: 1,
        slideBy: 'page',
        nav: true,
        autoplay: true,
        autoplayHoverPause: true
    });




    //news
    var newsSlider = tns({
        container: '.news-slider',
        items: 3,
        slideBy: 'page',
        nav: true,
        gutter: 50
    });

    var newsSliderArrows = document.querySelector('.news-slider-arrows');
    newsSliderArrows.querySelector('.icon-chevr-left').addEventListener('click', function () {
        newsSlider.goTo('prev');
    });

    newsSliderArrows.querySelector('.icon-chevr-right').addEventListener('click', function () {
        newsSlider.goTo('next');
    });






    //partners
    var partnersSlider = tns({
        container: '.partners-slider',
        items: 1,
        slideBy: 'page',
        nav: true
    });

    var partnersSliderArrows = document.querySelector('.partners-slider-arrows');

    partnersSliderArrows.querySelector('.icon-chevr-left').addEventListener('click', function () {
        partnersSlider.goTo('prev');
    });

    partnersSliderArrows.querySelector('.icon-chevr-right').addEventListener('click', function () {
        partnersSlider.goTo('next');
    });
}