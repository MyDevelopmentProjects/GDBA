if (window.Element && !Element.prototype.closest) {
    Element.prototype.closest =
    function(s) {
        var matches = (this.document || this.ownerDocument).querySelectorAll(s),
            i,
            el = this;
        do {
            i = matches.length;
            while (--i >= 0 && matches.item(i) !== el) {};
        } while ((i < 0) && (el = el.parentElement));
        return el;
    };
}

function NewsRotator(el, data) {
  this.data = data;
  this.el = el;
  this.changeSpeed = 6000;
  this.display = this.el.closest('[data-display]');
  this.controls = this.display.querySelector('[data-controls]');

  this.wrapper;
  this.date;
  this.link;
  this.title;
  this.interval;

  this.total = this.data.length;
  this.current = 0;

  this.assemble();
  this.setData(0);
  this.autorun();
}

NewsRotator.prototype.autorun = function() {
  var that = this;

  if(this.interval) {
    clearInterval(this.interval);
  }

  this.inteval = setInterval(function() {

    var nextSlide = that.current == that.total - 1 ? 0 : that.current + 1;

    that.setData(nextSlide);
  }, this.changeSpeed);
}

NewsRotator.prototype.setData = function(i) {
  var that = this;
  this.current = i;

  this.wrapper.classList.remove('fadein');
  this.wrapper.classList.add('fadeout');

  Array.prototype.forEach.call(this.controls.querySelectorAll('.bullet-list__item'), function(elem, i) {
    if(i == that.current) {
      elem.classList.add('active');
    } else {
      elem.classList.remove('active');
    }
  });

  setTimeout(function() {
    that.date.innerHTML = moment(that.data[i].date).format('DD MMMM YYYY');
    that.link.innerText = that.data[i].title;
    that.link.setAttribute('href', that.data[i].href);
    that.display.setAttribute('style', 'background-image: url(' + that.data[i].imgUrl + ')');

    that.wrapper.classList.remove('fadeout');
    that.wrapper.classList.add('fadein');
  }, 120);
}

NewsRotator.prototype.assemble = function() {
  var that = this;
  this.wrapper = document.createElement('div');
  this.wrapper.setAttribute('data-uid', Math.floor(Math.random() * 1000 + 9999));
  this.wrapper.classList.add('slider-details__content-wrap');

  this.date = document.createElement('p');
  this.date.classList.add('slider-details__date');
  this.wrapper.appendChild(this.date);

  this.title = document.createElement('h2');
  this.title.classList.add('slider-details__body');

  this.link = document.createElement('a');
  this.link.setAttribute('href', '#');

  this.title.appendChild(this.link);

  this.wrapper.appendChild(this.title);

  this.el.appendChild(this.wrapper);

  for (var i = 0; i < this.total; i++) {
    var b = document.createElement('li');
    b.classList.add('bullet-list__item');
    b.setAttribute('data-to', i);

    b.addEventListener('click', function(e) {
      that.setData(parseInt(e.target.getAttribute('data-to')));
    });
    that.controls.appendChild(b);
  }
}
