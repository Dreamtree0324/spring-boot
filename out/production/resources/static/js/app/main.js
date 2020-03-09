let main = {
    init : function(){
        let _this = this;
        $('#btn-save').on('click', function(){
            _this.save();
        })
    },
    save : function(){
        let data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val(),
        };

        $.ajax({
            type:'POST',
            url: '/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
          alert('글 등록이 완료 되었습니다.');
          location.reload();
        }).fail(function(error){
            alert('오류 : ' + error);
        });
    }
};

main.init();