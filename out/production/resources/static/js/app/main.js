let main = {
    init : function(){
        let _this = this;
        $('#btn-save').on('click', function(){
            _this.save();
        })
        $('#btn-search').on('click', function(){
            _this.osuSearch();
        })
        $('#btn-result').on('click', function () {
            _this.osuSearchResult();
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
    },
    osuSearch : function(){
        let data = {
            usernames: $('#user_name').val()
        }
        $.ajax({
            url:'/osuProfile',
            type:'POST',
            data:data.usernames,
            contentType: 'application/json; charset=utf-8',
            dataType:'json',
            success: function(datap) {
                document.getElementById("userId").setAttribute("value", JSON.parse(JSON.stringify(datap))[0].user_id);
                document.getElementById("userName").setAttribute("value", JSON.parse(JSON.stringify(datap))[0].username);
                document.getElementById("playCount").setAttribute("value", JSON.parse(JSON.stringify(datap))[0].playcount);
                document.getElementById("ppRank").setAttribute("value", JSON.parse(JSON.stringify(datap))[0].pp_rank);
                document.getElementById("ppCountryRank").setAttribute("value", JSON.parse(JSON.stringify(datap))[0].pp_country_rank);
                $('#btn-result').click();
            },// 요청 완료 시
            error:function(jqXHR) {
                console.log("실패입니다.");
            }// 요청 실패.
        });
    },
    osuSearchResult : function () {
        let data = {
            userId: $('#userId').val(),
            userName: $('#userName').val(),
            playCount: $('#playCount').val(),
            ppRank: $('#ppRank').val(),
            ppCountryRank: $('#ppCountryRank').val(),
        }
        $.ajax({
            type:'POST',
            url: '/osuSearch',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            location.reload();
        }).fail(function(error){
            alert('오류 : ' + error);
        });
    }
};

main.init();