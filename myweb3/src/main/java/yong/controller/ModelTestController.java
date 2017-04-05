package yong.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelTestController {
	
	/** 모델 테스트1(Map) */
	@RequestMapping("/modelTest1.do") // 진입 메서드에 메개변수로 선언해놓은 객체가 있다면 스프링이 만들어준다.
	public String modelTest1(Map model){ // 객채로 만들어져서 던져진다.
		model.put("result", "Map객체를 이용한 데이터 전달 !");
		return "model/modelSuccess";
	}
	/** 모델 테스트2(Model) */
	@RequestMapping("/modelTest2.do")
	public String modelTest2(Model model){
		model.addAttribute("result", "Model 객체를 이용한 데이터 전달 !");
		return "model/modelSuccess";
	}
	/** 모델 테스트3(ModelMap) */
	@RequestMapping("/modelTest3.do")
	public String modelTest3(ModelMap modelMap){
		modelMap.addAttribute("result", "ModelMap 객체를 이용한 데이터 전달 !");
		return "model/modelSuccess";
	}
	/** 모델 테스트4(Map 반환) */
	/*@RequestMapping("/model/modelSuccess.do") // 묵시적 뷰 이동
	public Map modelTest4(){ // 반환타입은 직접 만들어야한다.
		Map model = new HashMap();
		model.put("result", "Map을 반환해서 데이터 전달!");
		return model;
	}*/
	/** 모델 테스트5(Model 반환) */
	@RequestMapping("/model/modelSuccess.do") // 묵시적 뷰 이동
	public Model modelTest5(){
		Model model = new ExtendedModelMap(); // ModelMap으로 객채를 생성한다.
		model.addAttribute("result", "Model을 반환해서 데이터 전달!");
		return model;
	}
	
}
