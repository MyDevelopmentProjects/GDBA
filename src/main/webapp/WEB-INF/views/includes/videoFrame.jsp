<!-- Video modal demo -->
<div class="modal-host" id="video_modal">
    <div class="container container--modal">
        <div class="modal-dialog">
            <span class="modal-dialog__close"></span>
            <div class="modal-dialog__content">
                <iframe
                        class="video-iframe"
                        frameBorder="0"
                        width="100%"
                        height="530">
                </iframe>
            </div>
        </div>
    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function (event) {
        setTimeout(function() {
            var videoEls = document.getElementsByClassName('youvideo')
            for (var i = 0; i < videoEls.length; i++) {
                videoEls[i].addEventListener('click', function (event) {
                    var m = new Modal(document.getElementById('video_modal'), event.target.getAttribute('video-uri'));
                    setTimeout(function () {
                        m.show();
                    }, 200)
                });
            }
        }, 1000)
    });
</script>