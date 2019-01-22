function Modal(host) {
  var that = this;
  this.host = host;
  this.closeBtn = this.host.querySelector('.modal-dialog__close');
  this.videoFrame = this.host.querySelector('.video-iframe');

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
  }, 130);
}

Modal.prototype.show = function() {
  this.host.classList.add('modal-host--show');
  this.host.classList.add('modal-host--fadein');
}
