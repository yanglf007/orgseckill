/**
 * Created by Administrator on 2017/7/10 0010.
 */
//主要的交互逻辑
var seckill ={
        url:{
            new : function () {
                return "/seckill/getTime"
            },
            exporse : function (seckillId) {
                return  "/seckill/"+seckillId+"/exploser"
            },
            exection : function (seckillId,userPhone,md5) {
                return "/seckill/" + seckillId+"/"+userPhone+"/"+md5+"/exection";
            }
        },
    handleSeckillkill : function (seckillId,node) {
        node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">秒杀开始</button>');
        $.get(seckill.url.exporse(seckillId),{},function (result) {
            if(result!=null&&result['success']){
                var exposer = result['data'];
                if (exposer){
                    var md5 = exposer['md5'];
                    $('#killBtn').one('click',function () {
                        $(this).addClass('disabled');
                        $.get(seckill.url.exection(seckillId,$.cookie('killPhone'),md5),{},function (result) {
                            if(result&&result['success']){
                                var killResult = result['data'];
                                var state = killResult['state'];
                                var stateInfo = killResult['stateInfo'];
                                var successSeckill = killResult['successSeckill'];
                                var userPhone = successSeckill['userPhone'];

                                node.html('<span class="label label-success">'+userPhone+stateInfo+'</span>');
                            }else{
                                var stateInfo = result['error'];
                                node.html('<span class="label label-success">'+stateInfo+'</span>');

                            }
                        });
                    });


                    node.show();
                }else {
                    var nowTime = exposer['now'];
                    var startTime = exposer['startTime'];
                    var endTime = exposer['endTime'];
                    seckill.countDown(seckillId,nowTime,startTime,endTime);
                }
            }else{
                console.debug(result['data']);
            }
        });
        },
    validatePhone : function (phone) {
        if(phone&&phone.length==11&&!isNaN(phone)){
            return true;
        }else {
            return false;
        }
    },
    countDown:function (seckillId,nowTime,startTime,endTime) {
        var seckillBox = $('#seckill-box');
        if(nowTime>endTime){
            seckillBox.html('活动已经结束');
        }else if(nowTime<startTime){
            //活动还未开始
            var killTime=new Date(startTime-0+1000);
            seckillBox.countdown(killTime,function (event) {
                var format = event.strftime('秒杀倒计时：%D天,%H时,%M分,%S秒');
                seckillBox.html(format);
            }).on('finish.countdown',function () {
                seckill.handleSeckillkill(seckillId,seckillBox);
            });

        }else if(startTime<=nowTime&&nowTime<=endTime){
            seckill.handleSeckillkill(seckillId,seckillBox);
            //活动正在进行
        }

    },
    detail: {



            init: function (params) {
                var killPhone = $.cookie('killPhone');
                if (!seckill.validatePhone(killPhone)) {
                    var killPhoneModel = $('#killPhoneModel');
                    killPhoneModel.modal({
                        show: true,
                        backdrop: 'static',
                        keyboard: true
                    });
                    //点击事件绑定
                    var killPhoneBtn = $('#killPhoneBtn');
                    killPhoneBtn.click(function () {
                        var inputPhone = $('#killphonekey').val();
                        //将电话写入cookie

                        if(seckill.validatePhone(inputPhone)){
                            console.debug(inputPhone)
                            $.cookie('killPhone',inputPhone,{expires:7,path:'/seckill'});
                            window.location.reload();
                        }else {
                            $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误</label>').show(300);
                        }
                    });

                }

                var seckillId = params['seckillId'];
                var startTime = params['startTime'];
                var endTime = params['endTime'];
                $.get(seckill.url.new(),{},function (result) {
                    if(result!=null&&result['success']){
                        var nowTime = result['data'];
                        seckill.countDown(seckillId,nowTime,startTime,endTime);
                    }else {
                        console.log(result)
                    }
                })
            }
        }
}