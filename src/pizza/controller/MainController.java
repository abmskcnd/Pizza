package pizza.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pizza.entity.CTGHEntity;
import pizza.entity.GioHangEntity;
import pizza.entity.KichThuocEntity;
import pizza.entity.PizzaEntity;
import pizza.entity.TaiKhoanEntity;
import pizza.query.QueryT;
@Transactional
@Controller
@RequestMapping("/user")
public class MainController {
	
	@Autowired
	SessionFactory factory;
	@Autowired
	ServletContext context;
	TaiKhoanEntity dangky=new TaiKhoanEntity();
	KichThuocEntity kt=new KichThuocEntity();
	PizzaEntity pz=new PizzaEntity();
	GioHangEntity gh=new GioHangEntity();
	CTGHEntity ctgh=new CTGHEntity();
	@RequestMapping("/giohang")
	public String giohang(){	
		return "giohang";
	}
	@RequestMapping("/admin")
	public String admin(){	
		return "admin";
	}
	@RequestMapping("/home")
	public String home(){	
		return "home";
	}
	@RequestMapping(value="/pizza",method = RequestMethod.GET)
	public String pizza(ModelMap model,ModelMap mm){
		
		Session session = factory.getCurrentSession();
			String hql = "from PizzaEntity";
			Query query = session.createQuery(hql);
			List<PizzaEntity> list = query.list();
			
			model.addAttribute("list",list);
			model.addAttribute("piz", new PizzaEntity());
			model.addAttribute("gh", new GioHangEntity());
			model.addAttribute("ctgh", new CTGHEntity());
			return "dathang";
	}
	
	@RequestMapping(value="/pizza",method = RequestMethod.POST)
	public void pizzapost(HttpServletRequest req, HttpServletResponse res, HttpSession ss) throws IOException{
		QueryT qt = new QueryT(factory);
		String userId = ss.getAttribute("iduser").toString();
		String pizzaId = req.getParameter("idPizza");
		String sizeId = req.getParameter("size");
		System.out.println(userId);
		TaiKhoanEntity acc = ((TaiKhoanEntity)qt.select("TaiKhoanEntity", new String[]{"id_taikhoan="+userId}).get(0));
		List<Object> ghL = qt.select("GioHangEntity",new String[]{"user.id_taikhoan="+userId,"tt=false"});
		if (ghL.size() == 0) {
			gh.setUser(acc);
			gh.setTt(false);
			qt.add(gh);
		}
		ctgh.setGh(((GioHangEntity)ghL.get(0)));
		ctgh.setKt(((KichThuocEntity)qt.select("KichThuocEntity",new String[] {"id_kichthuoc="+sizeId}).get(0)));
		ctgh.setPizza(((PizzaEntity)qt.select("PizzaEntity",new String[] {"id_pizza="+pizzaId}).get(0)));
		ctgh.setSl(1);
		qt.add(ctgh);
		// Kiểm tra user đã có GH chưa ?
		
		// Nếu rồi mà chưa thanh toán thì select id giỏ hàng rồi bỏ v
		
		// Nếu chưa thì tạo mới
		
		
		
	
		
		PrintWriter out = res.getWriter();
		out.print(pizzaId);
		
		
	}

	@RequestMapping("/miy")
	public String miy(){	
		return "miy";
	}
	@RequestMapping("/khaivi")
	public String khaivi(){	
		return "khaivi";
	}
	@RequestMapping("/thucuong")
	public String thucuong(){	
		return "thucuong";
	}
	
	
	@RequestMapping(value="/taotaikhoan",method = RequestMethod.GET)
	public String taotaikhoan(ModelMap model) throws ServletException, IOException {
	model.addAttribute("taikhoan", new TaiKhoanEntity());
	return "taotaikhoan";
	}

	@RequestMapping(value="/taotaikhoan",method = RequestMethod.POST)
	public String taotaikhoanpost(@ModelAttribute("taikhoan") TaiKhoanEntity taikhoan,ModelMap model,BindingResult errors,HttpServletRequest request) throws ServletException, IOException{
		
		String rematkhau=request.getParameter("rematkhau");
		
		if(taikhoan.getHoten().length()==0) {
			errors.rejectValue("hoten","taikhoan","Vui Lòng Nhập Họ Tên!");	
			
		}
		else if(taikhoan.getTaikhoan().trim().length()==0) {
			errors.rejectValue("taikhoan","taikhoan","Vui Lòng Tài Khoản");	
			
		}
		else if(taikhoan.getEmail().trim().length()==0) {
			errors.rejectValue("email","taikhoan","Vui Lòng Nhập Gmail!");	
			
		}
		else if(taikhoan.getSdt().trim().length()==0) {
			errors.rejectValue("sdt","taikhoan","Vui Lòng Nhập SĐT");	
			
		}
		else if(taikhoan.getSdt().matches("0[0-9]{10}")) {
			errors.rejectValue("sdt","taikhoan","Số Điện Thoại Không Hợp Lệ");	
			
		}
		else if(taikhoan.getMatkhau().trim().length()==0) {
			errors.rejectValue("matkhau","taikhoan","Vui Lòng Nhập Mật Khẩu");	
			
		}
		else if(!taikhoan.getMatkhau().equals(rematkhau)) {
			errors.rejectValue("matkhau","taikhoan","Hai Mật Khẩu Không Trùng Nhau");	
			
		}
		else if(errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau");
		}
		else {
			Session session = factory.openSession();
			Transaction t= session.beginTransaction();	
			String hql = "FROM TaiKhoanEntity";
			Query query = session.createQuery(hql);
			List<TaiKhoanEntity> listAcc = query.list();
			for(TaiKhoanEntity i: listAcc) {
				if(taikhoan.getTaikhoan().equals(i.getTaikhoan())) {
					
					model.addAttribute("message", "Tài Khoản Đã Có Người Sử Dụng");
					return "taotaikhoan";
				}
				else if(taikhoan.getEmail().equals(i.getEmail())) {
					
					model.addAttribute("message", "Email Đã Có Người Sử Dụng");
					return "taotaikhoan";
				}
				else if(taikhoan.getSdt().equals(i.getSdt())) {
					
					model.addAttribute("message", "SDT  Đã Có Người Sử Dụng");
					return "taotaikhoan";
				}
				
			}
		
			try {
			
				
				taikhoan.setQuyen(1);
				session.save(taikhoan);
				t.commit();
				model.addAttribute("message", "Đăng Ký Thành Công");
			}
			catch(Exception ex) {
				t.rollback();
			}
			finally {
				session.close();
			}
			return "taotaikhoan";
			
		}
			
		return "taotaikhoan";
	
		
	}
	
	@RequestMapping("test")
	public void test() {
		QueryT qt = new QueryT(factory);
		String[] patterns = {"id_pizza=1","detail=ABC"};
		System.out.println(((PizzaEntity)qt.select("PizzaEntity", patterns).get(0)).getName());
	}
}
