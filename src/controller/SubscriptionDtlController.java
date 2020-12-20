package controller;

import entity.SubscriptionDtl;
import exception.DuplicatedeleteFail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.SubscriptionDtlService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/subscriptionDtl")
public class SubscriptionDtlController {
    @Autowired
    private SubscriptionDtlService subscriptionDtlService;

    @ExceptionHandler(DuplicatedeleteFail.class)
    public ModelAndView DuplicatedeleteFail(Exception e){
        return new ModelAndView("memberCenter","e",e);
    }
//    查询客房信息
    @RequestMapping("/selectOrderRoom")
    public String selectOrderRoom(Integer id, Map map){
        List<SubscriptionDtl> list = subscriptionDtlService.selectOrderRoom(id);
        map.put("Subscription_dtls",list);
        return "subscriptionDetail";
    }
    //    订单详情信息
    @RequestMapping("/subscriptionView")
    public String subscriptionView(Integer id, Map map){
        List<SubscriptionDtl> list = subscriptionDtlService.selectOrderRoom(id);
        map.put("Subscription_dtls",list);
        return "subscriptionView";
    }




//    删除用户订单
    @RequestMapping("/deleteOrderRoom")
    public String deleteOrderRoom(Integer id,Integer sid) throws Exception{
        subscriptionDtlService.deleteOrderRoom(id);
        return "redirect:/subscriptionDtl/selectOrderRoom?id="+sid;
    }

}
