package controller;

import constant.Constant;
import entity.Member;
import entity.Room;
import entity.Subscription;
import entity.SubscriptionDtl;
import exception.DuplicateReserveIsNull;
import exception.DuplicateUsernameNoExistException;
import exception.DuplicatedeleteFail;
import exception.ManagerDuplicateReserveIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.RoomService;
import service.SubscriptionService;
import vo.ManagerQueryVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;


    @ExceptionHandler(DuplicateUsernameNoExistException.class)
    public ModelAndView loginExceptionHandler(Exception e){
        return new ModelAndView("memberCenter","e",e);
    }
    @ExceptionHandler(DuplicatedeleteFail.class)
    public ModelAndView DuplicatedeleteFail(Exception e){
        return new ModelAndView("memberCenter","e",e);
    }
    @ExceptionHandler(DuplicateReserveIsNull.class)
    public ModelAndView DuplicateReserveIsNull(Exception e){
        return new ModelAndView("memberCenter","e",e);
    }
    @ExceptionHandler(ManagerDuplicateReserveIsNull.class)
    public ModelAndView ManagerDuplicateReserveIsNull(Exception e){
        return new ModelAndView("manager/subscriptionList","e",e);
    }
    //会员中心&客房预定
    @RequestMapping("/center")
    public String center(HttpSession session,Map map){
        Member member=(Member)session.getAttribute("member");
        if (member==null){
            return "login";
        }else {
            List<Subscription> subscriptions=subscriptionService.findStatusUnconfirmed(member.getId(),
                    Constant.SUBSCRIPTION_STATUS_UNCONFIRMED);
            map.put("subscriptions", subscriptions);
            return "memberCenter";
        }

    }
    //历史订单
    @RequestMapping("/history")
    public String history(HttpSession session,Map map){
        Member member = (Member) session.getAttribute("member");
        List<Subscription> subscriptions=subscriptionService.findHistorySubscription(member.getId());
        map.put("subscriptions", subscriptions);
        return  "historySubscription";

    }

    //创建新订单
    @RequestMapping("/create")
    public String create(Subscription subscription,HttpSession session){
        Member member=(Member)session.getAttribute("member");
        subscription.setMid(member.getId());
        subscriptionService.create(subscription);
        return "redirect:/subscription/center";
    }

    //    删除一条订单
    @RequestMapping(value = "/deleteOneItem")
    public String deleteOneItem(Integer id)throws Exception{
        subscriptionService.deleteOneItem(id);
        return "redirect:/subscription/center";
    }


    //编辑订单联系人信息
    @RequestMapping("/showEdit")
    public String showEdit(Integer id,Map map){
        Subscription subscription=subscriptionService.findById(id);
        map.put("subscription", subscription);
        return "editSubscription";
    }

    @RequestMapping("/edit")
    public String edit(Subscription subscription){
        subscriptionService.edit(subscription);
        return "redirect:/subscription/center";
    }




    //    管理员查询List<SubscriptionService>
    @RequestMapping("/manager/managerQueryOrder")
    public String managerQueryOrder(ManagerQueryVo managerQueryVo, Map map, HttpSession session)throws Exception{
        if(managerQueryVo == null){
            managerQueryVo = (ManagerQueryVo) session.getAttribute("managerQueryVo");
        }
        List<Subscription> list = subscriptionService.selectBySubscriptionCriteria(managerQueryVo);
        session.setAttribute("managerQueryVo",managerQueryVo);
        map.put("managerQueryOrders",list);
        return "manager/subscriptionList";
    }

}
