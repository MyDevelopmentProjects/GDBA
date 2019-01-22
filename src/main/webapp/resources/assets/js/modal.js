function Modal(host, url) {
  var that = this;
  this.host = host;
  this.closeBtn = this.host.querySelector('.modal-dialog__close');
  this.videoFrame = this.host.querySelector('.video-iframe');
  this.videoFrame.setAttribute("src", url + "?enablejsapi=1&autoplay=1")
  this.closeBtn.addEventListener('click', function() {
    if(that.videoFrame) {
      that.videoFrame.contentWindow.postMessage('{"event":"command","func":"pauseVideo","args":""}', '*');
    }

    that.hide();
  });
}

Modal.prototype.hide = function() {
  var that = this;

  this.host.classList.add('modal-host--fadeout');
  setTimeout(function() {
    that.host.classList.remove('modal-host--show');
    that.host.classList.remove('modal-host--fadeout');
  }, 130);
}

Modal.prototype.show = function() {
  this.host.classList.add('modal-host--show');
  this.host.classList.add('modal-host--fadein');
}
