function ImageSlider(el) {
  var that = this;
  this.el = el;
  this.interval;
  this.activeSlide = 0;
  this.slideDelay = 6000;
  this.slides = Array.prototype.slice.call(this.el.querySelectorAll('.image-slider__slide'));
  this.lrControls = this.el.querySelector('.lr-controls');

  this.setSlide(0);

  this.run();

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


ImageSlider.prototype.fadeIn = function(img) {
  img.classList.add('image-slider__slide--show');
  img.classList.add('image-slider__slide--fadein');
}

ImageSlider.prototype.fadeOut = function(img) {
  img.classList.remove('image-slider__slide--fadein');
  img.classList.add('image-slider__slide--fadeout');

  setTimeout(function() {
    img.classList.remove('image-slider__slide--show');
  }, 100);
}

ImageSlider.prototype.run = function() {
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

ImageSlider.prototype.setSlide = function(slideIdx) {
  var that = this;
  this.fadeIn(this.slides[slideIdx]);

  this.activeSlide = slideIdx;

  this.slides.forEach(function(slide, i) {
    if(i == slideIdx) {
      that.fadeIn(slide);
    } else {
      that.fadeOut(slide);
    }
  });

  if(that.activeSlide > 0) {
    that.lrControls.querySelector('[data-back]').classList.add('active');
  } else {
    that.lrControls.querySelector('[data-back]').classList.remove('active');
  }

  if(that.activeSlide < that.slides.length - 1) {
    that.lrControls.querySelector('[data-next]').classList.add('active');
  } else {
    that.lrControls.querySelector('[data-next]').classList.remove('active');
  }
}
