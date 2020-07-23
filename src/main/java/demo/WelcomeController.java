package demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	ExcelReader reader= new ExcelReader();
	
	@GetMapping("/hi")
	public String getHi() {
		return "welcome";
	}
	
	@GetMapping("/sheet")
	public String getSheetData(Model model){
		try {
			
			model.addAttribute("sheetRows",ExcelReader.readExcel());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sheetData";
	}
}
