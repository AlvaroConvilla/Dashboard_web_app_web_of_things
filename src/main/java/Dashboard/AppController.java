package Dashboard;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    AppService appService;

    @RequestMapping("/")
    public ModelAndView index() throws ParseException {
        /*List<Boolean> states = appService.estados();
        List<Boolean> alarms = appService.alarmas();


        ModelAndView result = new ModelAndView("index").addObject("states", states);
        result.addObject("alarms", alarms);*/

        ModelAndView result = new ModelAndView("index");
        return result;
    }

    @RequestMapping("/init")
    public ModelAndView init() throws ParseException {
        /*List<Boolean> states = appService.estados();
        List<Boolean> alarms = appService.alarmas();


        ModelAndView result = new ModelAndView("index").addObject("states", states);
        result.addObject("alarms", alarms);*/

        ModelAndView result = new ModelAndView("init");
        return result;
    }

    @RequestMapping("/WeatherStation")
    public ModelAndView weatherStation()throws ParseException{
/*        List<Boolean> states = appService.estados();
        List<Boolean> alarms = appService.alarmas();


        ModelAndView result = new ModelAndView("WeatherStation").addObject("states", states);
        result.addObject("alarms", alarms);*/

        ModelAndView result = new ModelAndView("WeatherStation");
        return result;
    }

    @RequestMapping("/Dome")
    public ModelAndView dome()throws ParseException{
/*        List<Boolean> states = appService.estados();
        List<Boolean> alarms = appService.alarmas();

        ModelAndView result = new ModelAndView("Dome").addObject("states", states);
        result.addObject("alarms", alarms);*/
        ModelAndView result = new ModelAndView("Dome");
        return result;
    }

    @RequestMapping("/Mount")
    public ModelAndView mount()throws ParseException{
/*        List<Boolean> states = appService.estados();
        List<Boolean> alarms = appService.alarmas();

        ModelAndView result = new ModelAndView("Mount").addObject("states", states);
        //result.addObject("states", states);
        result.addObject("alarms", alarms);*/

        ModelAndView result = new ModelAndView("Mount");
        return result;
    }

    @RequestMapping("/Camera")
    public ModelAndView camera()throws ParseException{
/*        List<Boolean> states = appService.estados();
        List<Boolean> alarms = appService.alarmas();

        ModelAndView result = new ModelAndView("Camera").addObject("states", states);
        //result.addObject("states", states);
        result.addObject("alarms", alarms);*/

        ModelAndView result = new ModelAndView("Camera");
        return result;
    }
    @RequestMapping("/Fotos")
    public ModelAndView fotos()throws ParseException{
        /*List<Boolean> states = appService.estados();
        List<Boolean> alarms = appService.alarmas();

        ModelAndView result = new ModelAndView("Fotos").addObject("states", states);
        //result.addObject("states", states);
        result.addObject("alarms", alarms);*/

        ModelAndView result = new ModelAndView("Fotos");
        return result;
    }
}