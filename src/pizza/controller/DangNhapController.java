package pizza.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pizza.entity.TaiKhoanEntity;
@Transactional
@Controller
@RequestMapping("/test")
public class DangNhapController {
	TaiKhoanEntity dangnhap=new TaiKhoanEntity();
	boolean check = false;
	boolean checkadmin = false;
	@Autowired
	SessionFactory factory;
	@Autowired
	ServletContext context;
	@RequestMapping(value = "/dangnhap", method = RequestMethod.GET)
	public String dangnhap(ModelMap mm) throws ServletException, IOException {
		
		if ( check ==true && checkadmin==true) {
			return "admin";
		}
		else if(check ==true && checkadmin==false) {
			return "dathang";
		}
		else {
			mm.addAttribute("dangnhap", new TaiKhoanEntity());
			return "dangnhap";
		}	
	}
	@RequestMapping(value = "dangnhap", method = RequestMethod.POST)
	public String dangnhappost(@ModelAttribute("dangnhap") TaiKhoanEntity taikhoan, HttpSession ss, ModelMap mm)
			throws ServletException, IOException {
		
		Session session = factory.getCurrentSession();
		String hql = "FROM TaiKhoanEntity";
		Query query = session.createQuery(hql);
		
		List<TaiKhoanEntity> listAcc = query.list();

		
		for (TaiKhoanEntity ktra : listAcc) {
			if (taikhoan.getTaikhoan().equals(ktra.getTaikhoan()) && taikhoan.getMatkhau().equals(ktra.getMatkhau())
			&&  ktra.getQuyen()==1) {
				check = true;		
				ss.setAttribute("dangnhap", ktra.getTaikhoan());
				ss.setAttribute("iduser", ktra.getId_taikhoan());
			}
			else if (taikhoan.getTaikhoan().equals(ktra.getTaikhoan()) && taikhoan.getMatkhau().equals(ktra.getMatkhau())
					&&  ktra.getQuyen()==0) {
						checkadmin = true;		
						ss.setAttribute("dangnhap", ktra.getTaikhoan());
						ss.setAttribute("iduser", ktra.getId_taikhoan());
					}
			}
		if(checkadmin == true) {
			
			return "redirect:../user/admin.htm";
		}
		else if(check == true )
		{
			ss.setAttribute("kt", "yes");
			return "redirect:../user/pizza.htm";
		}
		else {
		
			
			mm.addAttribute("message", "Đăng nhập thất bại!");
		}

		return "dangnhap";
	}
		@RequestMapping(value = "/dangxuat", method = RequestMethod.GET)
	public String dangxuat(ModelMap mm, HttpSession ss) throws ServletException, IOException {
			check=false;
			checkadmin=false;
			ss.removeAttribute("kt");
			ss.removeAttribute("dangnhap");
			return "redirect:../test/dangnhap.htm";

	}
}
