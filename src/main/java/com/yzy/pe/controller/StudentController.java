package com.yzy.pe.controller;

import com.yzy.pe.entity.*;
import com.yzy.pe.service.StudentService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 学生controller
 *
 * @author YanZiyi
 * @create 2019-03-29 9:49
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping(value = "/getMyName", method = RequestMethod.POST)
    public User getMyMsg( HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        return user;
    }

    @RequestMapping("/getMyMsg")
    public ModelAndView getAddPoint() {
        ModelAndView mv = new ModelAndView("my_msg");
        return mv;
    }

    /**
     * Description 个人加分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getAddPoint")
    @ResponseBody
    public List<AddPoint> getAddPoint(AddPoint addPoint,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "10") int pageSize) {
        return studentService.getAddPoint(addPoint, pageNum, pageSize);
    }

    /**
     * Description 个人扣分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getDeletePoint")
    @ResponseBody
    public List<DeletePoint> getDeletePoint(DeletePoint deletePoint,
                                            @RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "10") int pageSize) {
        return studentService.getDeletePoint(deletePoint, pageNum, pageSize);
    }

    /**
     * Description 个人惩罚信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getPunishList")
    @ResponseBody
    public List<Punish> getPunishList(Punish punish,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "10") int pageSize) {
        return studentService.getPunishList(punish, pageNum, pageSize);
    }

    /**
     * Description 个人奖励信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getRewardList")
    @ResponseBody
    public List<Reward> getRewardList(Reward reward,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "10") int pageSize) {
        return studentService.getRewardList(reward, pageNum, pageSize);
    }

    /**
     * Description 我的区队信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getUserTeam")
    @ResponseBody
    public Team getUserTeam(String userId) {
        return studentService.getUserTeam(userId);
    }

    /**
     * Description 区队扣分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getTeamDeletePoint")
    @ResponseBody
    public List<DeletePoint> getTeamDeletePoint(DeletePoint deletePoint,
                                                @RequestParam(defaultValue = "1") int pageNum,
                                                @RequestParam(defaultValue = "10") int pageSize) {
        return studentService.getTeamDeletePoint(deletePoint, pageNum, pageSize);
    }

}
