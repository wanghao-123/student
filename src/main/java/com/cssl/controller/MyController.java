package com.cssl.controller;

import com.cssl.pojo.Options;
import com.cssl.pojo.Subject;
import com.cssl.pojo.Users;
import com.cssl.pojo.Votes;
import com.cssl.service.OptionsService;
import com.cssl.service.SubjectService;
import com.cssl.service.UsersService;
import com.cssl.service.VotesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private OptionsService optionsService;
    @Autowired
    private VotesService votesService;
    @GetMapping(value = "/logon")
    @ResponseBody
    public List logon(Users users,HttpSession session){
        List<Users> users1 = usersService.selectAll(users);
        if(users1.size()>0){
            session.getServletContext().setAttribute("userMsg",users1);
        }
        return users1;
    }
    @GetMapping("/inspectName")
    @ResponseBody
    public int inspectName(Users users){
        return usersService.selectName(users);
    }
    @GetMapping("/addUsers")
    @ResponseBody
    public int addUsers(Users users){
        users.setIsAdmin(0);
        return usersService.insertUser(users);
    }
    @RequestMapping("/selectList/{PageIndex}/{type}")
    //ordinary
    public String selectSubject(Model m, Subject subject, @PathVariable int PageIndex, @PathVariable String type){
        PageHelper.startPage(PageIndex, 3);
        List<Map<String, Object>> maps = subjectService.selectSubject(subject);
        PageInfo po = new PageInfo(maps);
        m.addAttribute("ShowList",po);
        m.addAttribute("type",type);
        return "votelist";
    }
    @RequestMapping("/removeUser")
    public String removeUser(HttpSession session){
        session.invalidate();
        return "login";
    }
    @RequestMapping("/Viewvote/{type}/{id}")
    public String Viewvote(Model model, @PathVariable int id,@PathVariable String type){
        Subject subject =new Subject(id);
        List<Map<String, Object>> options = optionsService.selectOptions(subject);
        List<Map<String, Object>> subjects = subjectService.selectSubject(subject);
        model.addAttribute("options",options);
        model.addAttribute("subjects",subjects);
        if(type.equals("see")){
            return "voteview";
        }else if(type.equals("join")){
            return "vote";
        }else{
            return "";
        }

    }
    @GetMapping("/selectTitle")
    @ResponseBody
    public int selectTitle(Subject subject){
        return subjectService.selectTitle(subject);
    }
    @GetMapping("/InserSubject")
    @ResponseBody
    public int InserSubject(@RequestParam(value = "arr[]") String[] arr,Subject subject){
        int i1 = subjectService.insertSubject(subject);
        int i2;
        if(i1>0){
            i2=1;
            for (int i = 0; i < arr.length; i++) {
                Options options = new Options(arr[i],subject);
                int i3 = optionsService.insertOptions(options);
                if(i3>0){
                    i2=2;
                }else{
                    i2=0;
                }
            }
        }else{
            i2=0;
        }
        return i2;
    }
    @GetMapping("/CheckTheVote")
    @ResponseBody
    public int CheckTheVote(Votes votes){
        return votesService.selectVotes(votes);
    }
    @GetMapping("/addVote")
    @ResponseBody
    public int addVote(@RequestParam(value = "array[]") Integer[] array,Votes votes){
        int result=0;
        for (int i = 0; i <array.length ; i++) {
            Options options =new Options();
            options.setO_id(array[i]);
            votes.setOptions(options);
            result=votesService.insertVotes(votes);
            if(result<=0){
                break;
            }
        }
        return result;
    }

    @GetMapping("/PageValidation")
    @ResponseBody
    public int PageValidation(HttpSession session){
        List<Users> users=(List<Users>)session.getServletContext().getAttribute("userMsg");
        return users.get(0).getIsAdmin();
    }

    @GetMapping("/delSubject")
    @ResponseBody
    public int delSubject(Subject subject){
        return subjectService.deleteAll(subject);
    }
}
