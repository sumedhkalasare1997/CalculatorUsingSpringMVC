package com.telusko;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	//@ResponseBody
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response)
	{
		//HttpHeaders headers=new HttpHeaders();
		//headers.add("Content-Type", "application/json");
		String str=request.getParameter("op");
		
		

		System.out.println("Inside Handler");
		int i=Integer.parseInt(request.getParameter("num1"));
		System.out.println("i is : "+i);
     	int j=Integer.parseInt(request.getParameter("num2"));
     	System.out.println("j : "+j);
     	int k=0;
     	if(str.equals("+"))
		 k=i+j;
     	else if(str.equals("-"))
			k=i-j;
		else if(str.equals("*"))
			k=i*j;
		else if(str.equals("/"))
			k=i/j;
		else if(str.equals(null))
			try {
				response.getWriter().println("Please enter valid operation");
				//System.exit(0);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result", k);
		//String result=Integer.toString(k);
        System.out.println("Hello..............");
        return mv;
	}

}
