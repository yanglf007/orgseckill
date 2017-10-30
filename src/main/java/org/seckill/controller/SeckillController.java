package org.seckill.controller;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value = "/{seckillId}/detail",method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model){
        logger.info("访问秒杀详情页面");
        if(seckillId==null){
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.queryById(seckillId);
        if(seckill==null){
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill",seckill);
        logger.debug(seckill.toString());
        return "detail";
    }

    @RequestMapping(value = "/list")
    public String list(Model model){

        List<Seckill> seckills = seckillService.queryAll(0, 3);
        model.addAttribute("list",seckills);
        logger.debug(seckills.toString());
        return "list";
    }

    @RequestMapping(value = "/{seckillId}/exploser" ,method = RequestMethod.GET
     ,produces = "application/json;chartset=utf-8")
    @ResponseBody
    public SeckillResult<Exposer> exploser(@PathVariable("seckillId") Long seckillId){

        logger.debug("########exploser########");
       SeckillResult<Exposer> result = null;
       try {
           Exposer exposer = seckillService.exporseSeckillURL(seckillId);
           result= new SeckillResult<Exposer>(true,exposer);
       }catch (Exception e){
           result = new SeckillResult<Exposer>(false,e.getMessage());
       }

        return result;
    }

    @RequestMapping(value = "/{seckillId}/{userPhone}/{md5}/exection" ,method = RequestMethod.GET ,
            produces = "application/json;chartset=utf-8")
    @ResponseBody
    public SeckillResult<SeckillExecution> exection(@PathVariable("seckillId") Long seckillId,
        @CookieValue(value = "killPhone",required = false) Long killPhone,
        @PathVariable("md5") String md5 ){
        if(killPhone==null){
            logger.debug("用户未注册");
            return new SeckillResult(false,"用户未注册");
        }
        SeckillResult<SeckillExecution> result = null;

        try {
            SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, killPhone, md5);
            result = new SeckillResult<SeckillExecution>(true,seckillExecution);
        }catch (Exception e){
            result = new SeckillResult<SeckillExecution>(false,e.getMessage());
        }
       return result;


    }

    @RequestMapping("/getTime")
    @ResponseBody
    public SeckillResult<Long> getTime(){
        Date date = new Date();
        return new SeckillResult<Long>(true,date.getTime());
    }
}
