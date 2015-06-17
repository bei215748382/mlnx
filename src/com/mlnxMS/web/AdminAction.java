package com.mlnxMS.web;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;

import org.apache.struts2.ServletActionContext;

import com.mlnxMS.core.Banner;
import com.mlnxMS.core.Contact;
import com.mlnxMS.core.Content;
import com.mlnxMS.core.Copyright;
import com.mlnxMS.core.Event;
import com.mlnxMS.core.Header;
import com.mlnxMS.core.Link;
import com.mlnxMS.core.Mail;
import com.mlnxMS.core.Navigation;
import com.mlnxMS.core.Notice;
import com.mlnxMS.core.Post;
import com.mlnxMS.core.Product;
import com.mlnxMS.core.Qrcode;
import com.mlnxMS.core.Recruitment;
import com.mlnxMS.core.Response;
import com.mlnxMS.core.User;
import com.mlnxMS.service.BannerService;
import com.mlnxMS.service.ContactService;
import com.mlnxMS.service.ContentService;
import com.mlnxMS.service.CopyrightService;
import com.mlnxMS.service.EventService;
import com.mlnxMS.service.HeaderService;
import com.mlnxMS.service.ImageService;
import com.mlnxMS.service.LinkService;
import com.mlnxMS.service.MailService;
import com.mlnxMS.service.NavigationService;
import com.mlnxMS.service.NoticeService;
import com.mlnxMS.service.PostService;
import com.mlnxMS.service.ProductService;
import com.mlnxMS.service.QrcodeService;
import com.mlnxMS.service.RecruitmentService;
import com.mlnxMS.service.ResponseService;
import com.mlnxMS.service.UserService;

public class AdminAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HeaderService headerService = new HeaderService();
	NavigationService navigationService = new NavigationService();
	BannerService bannerService = new BannerService();
	QrcodeService qrcodeService = new QrcodeService();
	LinkService linkService = new LinkService();
	CopyrightService copyrightService = new CopyrightService();
	ContentService contentService = new ContentService();
	ProductService productService = new ProductService();
	RecruitmentService recruitmentService = new RecruitmentService();
	ContactService contactService = new ContactService();
	ImageService imageService = new ImageService();
	UserService userService = new UserService();
	PostService postService = new PostService();
	ResponseService responseService = new ResponseService();
	NoticeService noticeService = new NoticeService();
	EventService eventService = new EventService();
	MailService mailService = new MailService();
	private int length = application.getRealPath("/").indexOf("webapps");
	/**
	 * 管理员注销
	 * 
	 * @throws IOException
	 */
	public void logout() throws IOException {
		session.removeAttribute("user");
		response.sendRedirect("MSlogin.jsp");
	}

	/**
	 * 显示页顶信息
	 */
	public void showHeader() {
		@SuppressWarnings("unchecked")
		List<Header> headers = headerService.findAll();
		request.setAttribute("headers", headers);
		this.forward("showHeader.jsp");
	}

	/**
	 * 添加页顶信息
	 * 
	 * @throws IOException
	 */
	public String comName;// 公司名称
	public File logo;// 客户端的文件对象
	public String logoFileName;// 文件名 xxxFileName
	public void addHeader() throws IOException {

		String path = ServletActionContext.getServletContext()
				.getRealPath("/WEB-INF").substring(0, length + 7)
				+ "/docs/upload";

		String newName = System.currentTimeMillis() + ""
				+ logoFileName.substring(logoFileName.lastIndexOf("."));

		File file = new File(path + "\\" + newName);

		OutputStream os = new FileOutputStream(file);

		InputStream is = new FileInputStream(logo);

		for (int i = 0; i < logo.length(); i++) {

			int num = is.read();
			os.write(num);

		}

		int wideth = 0, height = 0;
		try {
			File _file = new File(path + "\\" + newName); // 读入文件
			Image src = javax.imageio.ImageIO.read(_file); // 构造Image对象
			wideth = src.getWidth(null); // 得到源图宽
			height = src.getHeight(null); // 得到源图长
		} catch (Exception e) {
			e.printStackTrace();
		}

		is.close();
		os.close();

		Header header = new Header();
		header.setLogoImg(newName);
		header.setComName(comName);
		header.setLogoSize(wideth + "px*" + height + "px");
		header.setHeaderStatus(0);
		headerService.save(header);
		response.sendRedirect("admin!showHeader.action");

	}

	/**
	 * 删除指定的页顶信息
	 * 
	 * @throws IOException
	 */
	public int selcId1;
	public void deleteHeader() throws IOException {
		String path = ServletActionContext.getServletContext()
				.getRealPath("/WEB-INF").substring(0, length + 7)
				+ "/docs/upload";
		File file = new File(path + "\\"
				+ headerService.findById(selcId1).getLogoImg());
		file.delete();
		headerService.execDelete("header", selcId1, "hid");
		response.sendRedirect("admin!showHeader.action");

	}

	/**
	 * 更改页顶信息使用状态
	 */
	public int status1;
	public int currId1;
	public void changeHeader() throws IOException {

		// 准备启用，首先禁用原来页顶
		if (status1 == 0) {

			List<Header> headers = headerService.findAll();
			for (Iterator<Header> iterator = headers.iterator(); iterator
					.hasNext();) {
				Header header = (Header) iterator.next();
				if (header.getHeaderStatus() == 1) {
					header.setHeaderStatus(0);
				}
			}
			Header header = headerService.findById(currId1);
			header.setHeaderStatus(1);
			headerService.updateObject(header);
			response.sendRedirect("admin!showHeader.action");
			// 准备禁用当前页顶
		} else {
			Header header = headerService.findById(currId1);
			header.setHeaderStatus(0);
			headerService.updateObject(header);
			response.sendRedirect("admin!showHeader.action");
		}
	}

	/**
	 * 显示主页导航菜单
	 */
	public void showNavigation() {
		SortedMap[] navigations = navigationService.executeQuery(
				"select * from navigation where navType = ?", new Object[]{1});
		request.setAttribute("navigations", navigations);
		this.forward("showNavigation.jsp");
	}

	/**
	 * 显示论坛导航
	 */
	public void showBBSNav() {
		SortedMap[] navigations = navigationService.executeQuery(
				"select * from navigation where navType = ?", new Object[]{2});
		request.setAttribute("navigations", navigations);
		this.forward("showBBSNav.jsp");
	}

	/**
	 * 新增主页导航菜单
	 */
	public String navName;
	public int navPriority;
	public void addNavigation() throws IOException {
		Navigation navigation = new Navigation();
		navigation.setNavName(navName);
		navigation.setNavPriority(navPriority);
		navigation.setNavType(1);
		navigation.setNavStatus(0);
		navigationService.save(navigation);
		response.sendRedirect("admin!showNavigation.action");
	}

	/**
	 * 新增论坛导航菜单
	 * 
	 * @throws IOException
	 */
	public String navName2;
	public int navPriority2;
	public void addBBSNav() throws IOException {
		Navigation navigation = new Navigation();
		navigation.setNavName(navName2);
		navigation.setNavPriority(navPriority2);
		navigation.setNavType(2);
		navigation.setNavStatus(0);
		navigationService.save(navigation);
		response.sendRedirect("admin!showBBSNav.action");
	}

	/**
	 * 更改导航菜单使用状态
	 * 
	 * @throws IOException
	 */
	public int type;
	public int status2;
	public int currId2;
	public void changeNavigation() throws IOException {

		// 准备启用指定导航
		if (status2 == 0) {
			Navigation navigation = navigationService.findById(currId2);
			navigation.setNavStatus(1);
			navigationService.updateObject(navigation);
			if (type == 1) {
				response.sendRedirect("admin!showNavigation.action");
			} else {
				response.sendRedirect("admin!showBBSNav.action");
			}
			// 准备禁用指定导航
		} else {
			Navigation navigation = navigationService.findById(currId2);
			navigation.setNavStatus(0);
			navigationService.updateObject(navigation);
			if (type == 1) {
				response.sendRedirect("admin!showNavigation.action");
			} else {
				response.sendRedirect("admin!showBBSNav.action");
			}
		}
	}

	/**
	 * 修改指定的导航菜单信息
	 * 
	 * @throws IOException
	 */
	public int type1;
	public int modiId1;
	public String navName1;
	public int navPriority1;
	public void modifyNavigation() throws IOException {
		navName1 = new String(navName1.getBytes("ISO-8859-1"), "UTF8");
		Navigation navigation = navigationService.findById(modiId1);
		navigation.setNavName(navName1);
		navigation.setNavPriority(navPriority1);
		navigationService.updateObject(navigation);
		if (type1 == 1) {
			response.sendRedirect("admin!showNavigation.action");
		} else {
			response.sendRedirect("admin!showBBSNav.action");
		}

	}

	/**
	 * 删除指定导航菜单
	 */
	public int type2;
	public int selcId2;
	public void deleteNavigation() throws IOException {
		navigationService.execDelete("navigation", selcId2, "nid");
		if (type2 == 1) {
			response.sendRedirect("admin!showNavigation.action");
		} else {
			response.sendRedirect("admin!showBBSNav.action");
		}
	}

	/**
	 * 显示banner
	 */
	public void showBanner() {
		List<Banner> banners = bannerService.findAll();
		request.setAttribute("banners", banners);
		this.forward("showBanner.jsp");
	}

	/**
	 * 新增banner图片
	 * 
	 * @throws IOException
	 */
	public File banner;// 客户端的文件对象
	public String bannerFileName;// 文件名 xxxFileName
	public void addBanner() throws IOException {
		String path = ServletActionContext.getServletContext()
				.getRealPath("/WEB-INF").substring(0, length + 7)
				+ "/docs/upload";
		String newName = System.currentTimeMillis() + ""
				+ bannerFileName.substring(bannerFileName.lastIndexOf("."));

		File file = new File(path + "\\" + newName);

		OutputStream os = new FileOutputStream(file);

		InputStream is = new FileInputStream(banner);

		for (int i = 0; i < banner.length(); i++) {

			int num = is.read();
			os.write(num);

		}

		int wideth = 0, height = 0;
		try {
			File _file = new File(path + "\\" + newName); // 读入文件
			Image src = javax.imageio.ImageIO.read(_file); // 构造Image对象
			wideth = src.getWidth(null); // 得到源图宽
			height = src.getHeight(null); // 得到源图长
			System.out.println(wideth + "," + height);
		} catch (Exception e) {
			e.printStackTrace();
		}

		is.close();
		os.close();

		Banner banner = new Banner();
		banner.setBanImg(newName);
		banner.setBanSize(wideth + "px*" + height + "px");
		banner.setBanPriority(1);
		banner.setBanStatus(0);
		bannerService.save(banner);
		response.sendRedirect("admin!showBanner.action");
	}

	/**
	 * 更改指定banner的使用状态
	 * 
	 * @throws IOException
	 */
	public int status3;
	public int currId3;
	public void changeBanner() throws IOException {
		// 准备启用指定banner
		if (status3 == 0) {
			Banner banner = bannerService.findById(currId3);
			banner.setBanStatus(1);
			bannerService.updateObject(banner);
			response.sendRedirect("admin!showBanner.action");
			// 准备禁用指定banner
		} else {
			Banner banner = bannerService.findById(currId3);
			banner.setBanStatus(0);
			bannerService.updateObject(banner);
			response.sendRedirect("admin!showBanner.action");
		}
	}

	/**
	 * 修改指定banner信息
	 * 
	 * @throws IOException
	 */
	public int modiId10;
	public int banPriority1;
	public void modifyBanner() throws IOException {
		Banner banner = bannerService.findById(modiId10);
		banner.setBanPriority(banPriority1);
		bannerService.updateObject(banner);
		response.sendRedirect("admin!showBanner.action");
	}

	/**
	 * 删除指定banner
	 * 
	 * @throws IOException
	 */
	public int selcId3;
	public void deleteBanner() throws IOException {
		String path = ServletActionContext.getServletContext()
				.getRealPath("/WEB-INF").substring(0, length + 7)
				+ "/docs/upload";
		File file = new File(path + "\\"
				+ bannerService.findById(selcId3).getBanImg());
		file.delete();
		bannerService.execDelete("banner", selcId3, "bid");
		response.sendRedirect("admin!showBanner.action");
	}

	/**
	 * 显示页面内容
	 */
	public void showContent() {
		List<Content> contents = contentService.findAll();
		request.setAttribute("contents", contents);
		this.forward("showContent.jsp");
	}

	/**
	 * 新增页面内容
	 * 
	 * @throws IOException
	 */
	public String conTitle;
	public String conText;
	public void addContent() throws IOException {
		Content content = new Content();
		content.setConTitle(conTitle);
		content.setConText(conText);
		content.setConPosition(1);
		content.setConStatus(0);
		contentService.save(content);
		response.sendRedirect("admin!showContent.action");
	}

	/**
	 * 更改指定页面内容的使用状态
	 * 
	 * @throws IOException
	 */
	public int status7;
	public int currId7;
	public void changeContent() throws IOException {
		// 准备启用指定页面内容
		if (status7 == 0) {
			Content content = contentService.findById(currId7);
			content.setConStatus(1);
			contentService.updateObject(content);
			response.sendRedirect("admin!showContent.action");
			// 准备禁用指定页面内容
		} else {
			Content content = contentService.findById(currId7);
			content.setConStatus(0);
			contentService.updateObject(content);
			response.sendRedirect("admin!showContent.action");
		}
	}

	/**
	 * 修改指定的页面内容
	 * 
	 * @throws IOException
	 */
	public int modiId2;
	public String conTitle1;
	public String conText1;
	public int conPosition1;
	public void modifyContent() throws IOException {

		conTitle1 = new String(conTitle1.getBytes("ISO-8859-1"), "UTF-8");
		conText1 = new String(conText1.getBytes("ISO-8859-1"), "UTF-8");

		Content content = contentService.findById(modiId2);
		content.setConTitle(conTitle1);
		content.setConText(conText1);
		content.setConPosition(conPosition1);
		contentService.updateObject(content);
		response.sendRedirect("admin!showContent.action");
	}

	/**
	 * 删除指定页面内容
	 * 
	 * @throws IOException
	 */
	public int selcId7;
	public void deleteContent() throws IOException {
		contentService.execDelete("content", selcId7, "cid");
		response.sendRedirect("admin!showContent.action");
	}

	/**
	 * 显示二维码信息
	 */
	public void showQrcode() {
		List<Qrcode> qrcodes = qrcodeService.findAll();
		request.setAttribute("qrcodes", qrcodes);
		this.forward("showQrcode.jsp");
	}

	/**
	 * 添加二维码信息
	 * 
	 * @throws IOException
	 */
	public String qrName;
	public File qrcode;// 客户端的文件对象
	public String qrcodeFileName;// 文件名 xxxFileName
	public void addQrcode() throws IOException {
		String path = ServletActionContext.getServletContext()
				.getRealPath("/WEB-INF").substring(0, length + 7)
				+ "/docs/upload";
		String newName = System.currentTimeMillis() + ""
				+ qrcodeFileName.substring(qrcodeFileName.lastIndexOf("."));

		File file = new File(path + "\\" + newName);

		OutputStream os = new FileOutputStream(file);

		InputStream is = new FileInputStream(qrcode);

		for (int i = 0; i < qrcode.length(); i++) {

			int num = is.read();
			os.write(num);

		}

		int wideth = 0, height = 0;
		try {
			File _file = new File(path + "\\" + newName); // 读入文件
			Image src = javax.imageio.ImageIO.read(_file); // 构造Image对象
			wideth = src.getWidth(null); // 得到源图宽
			height = src.getHeight(null); // 得到源图长
			System.out.println(wideth + "," + height);
		} catch (Exception e) {
			e.printStackTrace();
		}

		is.close();
		os.close();

		Qrcode qrcode = new Qrcode();
		qrcode.setQrName(qrName);
		qrcode.setQrImg(newName);
		qrcode.setQrSize(wideth + "px*" + height + "px");
		qrcode.setQrStatus(0);
		qrcode.setQrPosition(1);
		qrcodeService.save(qrcode);
		response.sendRedirect("admin!showQrcode.action");
	}

	/**
	 * 更改指定的二维码的使用状态
	 * 
	 * @throws IOException
	 */
	public int status4;
	public int currId4;
	public void changeQrcode() throws IOException {
		// 准备启用指定二维码
		if (status4 == 0) {
			Qrcode qrcode = qrcodeService.findById(currId4);
			qrcode.setQrStatus(1);
			qrcodeService.updateObject(qrcode);
			response.sendRedirect("admin!showQrcode.action");
			// 准备禁用指定二维码
		} else {
			Qrcode qrcode = qrcodeService.findById(currId4);
			qrcode.setQrStatus(0);
			qrcodeService.updateObject(qrcode);
			response.sendRedirect("admin!showQrcode.action");
		}
	}

	/**
	 * 删除指定二维码信息
	 * 
	 * @throws IOException
	 */
	public int selcId4;
	public void deleteQrcode() throws IOException {
		String path = ServletActionContext.getServletContext()
				.getRealPath("/WEB-INF").substring(0, length + 7)
				+ "/docs/upload";
		File file = new File(path + "\\"
				+ qrcodeService.findById(selcId4).getQrImg());
		file.delete();
		qrcodeService.execDelete("qrcode", selcId4, "qid");
		response.sendRedirect("admin!showQrcode.action");
	}

	/**
	 * 修改指定二维码信息
	 * 
	 * @throws IOException
	 */
	public int modiId7;
	public String qrName1;
	public int qrPosition1;
	public void modifyQrcode() throws IOException {
		qrName1 = new String(qrName1.getBytes("ISO-8859-1"), "UTF-8");
		Qrcode qrcode = qrcodeService.findById(modiId7);
		qrcode.setQrName(qrName1);
		qrcode.setQrPosition(qrPosition1);
		qrcodeService.updateObject(qrcode);
		response.sendRedirect("admin!showQrcode.action");
	}

	/**
	 * 显示友链信息
	 */
	public void showLink() {
		List<Link> links = linkService.findAll();
		request.setAttribute("links", links);
		this.forward("showLink.jsp");
	}

	/**
	 * 新增友情链接信息
	 * 
	 * @throws IOException
	 */
	public String linkName;
	public String linkUrl;
	public void addLink() throws IOException {
		Link link = new Link();
		link.setLinkName(linkName);
		link.setLinkUrl(linkUrl);
		link.setLinkStatus(0);
		linkService.save(link);
		response.sendRedirect("admin!showLink.action");
	}

	/**
	 * 更改友链的使用状态
	 * 
	 * @throws IOException
	 */
	public int status5;
	public int currId5;
	public void changeLink() throws IOException {
		// 准备启用指定二维码
		if (status5 == 0) {
			Link link = linkService.findById(currId5);
			link.setLinkStatus(1);
			linkService.updateObject(link);
			response.sendRedirect("admin!showLink.action");
			// 准备禁用指定二维码
		} else {
			Link link = linkService.findById(currId5);
			link.setLinkStatus(0);
			linkService.updateObject(link);
			response.sendRedirect("admin!showLink.action");
		}
	}

	/**
	 * 删除指定的友链信息
	 * 
	 * @throws IOException
	 */
	public int selcId5;
	public void deleteLink() throws IOException {
		linkService.execDelete("link", selcId5, "lid");
		response.sendRedirect("admin!showLink.action");
	}

	/**
	 * 显示版权信息
	 */
	public void showCopyright() {
		List<Copyright> copyrights = copyrightService.findAll();
		request.setAttribute("copyrights", copyrights);
		this.forward("showCopyright.jsp");
	}

	/**
	 * 新增版权信息
	 * 
	 * @throws IOException
	 */
	public String cpDetail;
	public void addCopyright() throws IOException {
		Copyright copyright = new Copyright();
		copyright.setCpDetail(cpDetail);
		copyright.setCpStatus(0);
		copyrightService.save(copyright);
		response.sendRedirect("admin!showCopyright.action");
	}

	/**
	 * 更改版权信息
	 * 
	 * @throws IOException
	 */
	public int status6;
	public int currId6;
	public void changeCopyright() throws IOException {

		// 准备启用，首先禁用原来版权信息
		if (status6 == 0) {

			List<Copyright> copyrights = copyrightService.findAll();
			for (Iterator<Copyright> iterator = copyrights.iterator(); iterator
					.hasNext();) {
				Copyright copyright = (Copyright) iterator.next();
				if (copyright.getCpStatus() == 1) {
					copyright.setCpStatus(0);
				}
			}
			Copyright copyright = copyrightService.findById(currId6);
			copyright.setCpStatus(1);
			copyrightService.updateObject(copyright);
			response.sendRedirect("admin!showCopyright.action");
			// 准备禁用当前版权信息
		} else {
			Copyright copyright = copyrightService.findById(currId6);
			copyright.setCpStatus(0);
			copyrightService.updateObject(copyright);
			response.sendRedirect("admin!showCopyright.action");
		}
	}

	/**
	 * 删除指定的版权信息
	 * 
	 * @throws IOException
	 */
	public int selcId6;
	public void deleteCopyright() throws IOException {
		copyrightService.execDelete("copyright", selcId6, "cpId");
		response.sendRedirect("admin!showCopyright.action");
	}

	/**
	 * 显示产品信息
	 */
	public void showProduct() {
		List<Product> products = productService.findAll();
		request.setAttribute("products", products);
		this.forward("showProduct.jsp");
	}

	public String pduName;
	public File product;// 客户端的文件对象
	public String productFileName;// 文件名 xxxFileName
	public String pduDetail;
	public int pduPriority;
	public void addProduct() throws IOException {
		String path = ServletActionContext.getServletContext()
				.getRealPath("/WEB-INF").substring(0, length + 7)
				+ "/docs/upload";
		String newName = System.currentTimeMillis() + ""
				+ productFileName.substring(productFileName.lastIndexOf("."));

		File file = new File(path + "\\" + newName);

		OutputStream os = new FileOutputStream(file);

		InputStream is = new FileInputStream(product);

		for (int i = 0; i < product.length(); i++) {

			int num = is.read();
			os.write(num);

		}

		int wideth = 0, height = 0;
		try {
			File _file = new File(path + "\\" + newName); // 读入文件
			Image src = javax.imageio.ImageIO.read(_file); // 构造Image对象
			wideth = src.getWidth(null); // 得到源图宽
			height = src.getHeight(null); // 得到源图长
			System.out.println(wideth + "," + height);
		} catch (Exception e) {
			e.printStackTrace();
		}

		is.close();
		os.close();

		Product product = new Product();
		product.setPduName(pduName);
		product.setPduImg(newName);
		product.setPduSize(wideth + "px*" + height + "px");
		product.setPduDetail(pduDetail);
		product.setPduPriority(pduPriority);
		product.setPduStatus(0);
		productService.save(product);
		response.sendRedirect("admin!showProduct.action");
	}

	/**
	 * 更改指定产品信息的使用状态
	 * 
	 * @throws IOException
	 */
	public int status8;
	public int currId8;
	public void changeProduct() throws IOException {
		// 准备启用指定产品信息
		if (status8 == 0) {
			Product product = productService.findById(currId8);
			product.setPduStatus(1);
			productService.updateObject(product);
			response.sendRedirect("admin!showProduct.action");
			// 准备禁用指定产品信息
		} else {
			Product product = productService.findById(currId8);
			product.setPduStatus(0);
			productService.updateObject(product);
			response.sendRedirect("admin!showProduct.action");
		}
	}

	/**
	 * 修改指定产品信息
	 * 
	 * @throws IOException
	 */
	public int modiId3;
	public String pduName1;
	public String pduDetail1;
	public int pduPriority1;
	public void modifyProduct() throws IOException {
		pduName1 = new String(pduName1.getBytes("ISO-8859-1"), "UTF-8");
		pduDetail1 = new String(pduDetail1.getBytes("ISO-8859-1"), "UTF-8");
		Product product = productService.findById(modiId3);
		product.setPduName(pduName1);
		product.setPduDetail(pduDetail1);
		product.setPduPriority(pduPriority1);
		productService.updateObject(product);
		response.sendRedirect("admin!showProduct.action");
	}

	/**
	 * 删除指定的产品信息
	 * 
	 * @throws IOException
	 */
	public int selcId8;
	public void deleteProduct() throws IOException {
		String path = ServletActionContext.getServletContext()
				.getRealPath("/WEB-INF").substring(0, length + 7)
				+ "/docs/upload";
		File file = new File(path + "\\"
				+ productService.findById(selcId8).getPduImg());
		file.delete();
		productService.execDelete("product", selcId8, "pid");
		response.sendRedirect("admin!showProduct.action");
	}

	/**
	 * 显示招聘信息
	 */
	public void showRecruitment() {
		List<Recruitment> recruitments = recruitmentService.findAll();
		request.setAttribute("recruitments", recruitments);
		this.forward("showRecruitment.jsp");
	}

	/**
	 * 新增招聘信息
	 * 
	 * @throws IOException
	 */
	public String recruitPost;
	public String recruitDuty;
	public String recruitClaim;
	public void addRecruitment() throws IOException {
		Timestamp ts = new Timestamp(new Date().getTime());
		Recruitment recruitment = new Recruitment();
		recruitment.setRecruitPost(recruitPost);
		recruitment.setRecruitDuty(recruitDuty);
		recruitment.setRecruitClaim(recruitClaim);
		recruitment.setRecruitTime(ts);
		recruitment.setRecruitStatus(0);

		recruitmentService.save(recruitment);
		response.sendRedirect("admin!showRecruitment.action");
	}

	/**
	 * 更改指定招聘信息的使用状态
	 * 
	 * @throws IOException
	 */
	public int status9;
	public int currId9;
	public void changeRecruitment() throws IOException {
		// 准备启用指定招聘信息
		if (status9 == 0) {
			Recruitment recruitment = recruitmentService.findById(currId9);
			recruitment.setRecruitStatus(1);
			recruitmentService.updateObject(recruitment);
			response.sendRedirect("admin!showRecruitment.action");
			// 准备禁用指定招聘信息
		} else {
			Recruitment recruitment = recruitmentService.findById(currId9);
			recruitment.setRecruitStatus(0);
			recruitmentService.updateObject(recruitment);
			response.sendRedirect("admin!showRecruitment.action");
		}
	}

	/**
	 * 修改招聘信息
	 * 
	 * @throws IOException
	 */
	public int modiId4;
	public String recruitPost1;
	public String recruitDuty1;
	public String recruitClaim1;
	public void modifyRecruitment() throws IOException {
		recruitPost1 = new String(recruitPost1.getBytes("ISO-8859-1"), "UTF-8");
		recruitDuty1 = new String(recruitDuty1.getBytes("ISO-8859-1"), "UTF-8");
		recruitClaim1 = new String(recruitClaim1.getBytes("ISO-8859-1"),
				"UTF-8");
		Timestamp ts = new Timestamp(new Date().getTime());
		Recruitment recruitment = recruitmentService.findById(modiId4);
		recruitment.setRecruitPost(recruitPost1);
		recruitment.setRecruitDuty(recruitDuty1);
		recruitment.setRecruitClaim(recruitClaim1);
		recruitment.setRecruitTime(ts);
		recruitmentService.updateObject(recruitment);
		response.sendRedirect("admin!showRecruitment.action");
	}

	/**
	 * 删除指定招聘信息
	 * 
	 * @throws IOException
	 */
	public int selcId9;
	public void deleteRecruitment() throws IOException {
		recruitmentService.execDelete("recruitment", selcId9, "rid");
		response.sendRedirect("admin!showRecruitment.action");
	}

	/**
	 * 显示联系信息
	 */
	public void showContact() {
		List<Contact> contacts = contactService.findAll();
		request.setAttribute("contacts", contacts);
		this.forward("showContact.jsp");
	}

	/**
	 * 新增联系信息
	 * 
	 * @throws IOException
	 */
	public String ctPhone;
	public String ctFax;
	public String ctEmail;
	public String ctAdress;
	public void addContact() throws IOException {
		Contact contact = new Contact();
		contact.setCtPhone(ctPhone);
		contact.setCtFax(ctFax);
		contact.setCtEmail(ctEmail);
		contact.setCtAdress(ctAdress);
		contact.setCtStatus(0);
		contactService.save(contact);
		response.sendRedirect("admin!showContact.action");
	}

	/**
	 * 更改指定联系信息的使用状态
	 * 
	 * @throws IOException
	 */
	public int status10;
	public int currId10;
	public void changeContact() throws IOException {

		// 准备启用，首先禁用原来联系信息
		if (status10 == 0) {

			List<Contact> contacts = contactService.findAll();
			for (Iterator<Contact> iterator = contacts.iterator(); iterator
					.hasNext();) {
				Contact contact = (Contact) iterator.next();
				if (contact.getCtStatus() == 1) {
					contact.setCtStatus(0);
				}
			}
			Contact contact = contactService.findById(currId10);
			contact.setCtStatus(1);
			contactService.updateObject(contact);
			response.sendRedirect("admin!showContact.action");
			// 准备禁用当前联系信息
		} else {
			Contact contact = contactService.findById(currId10);
			contact.setCtStatus(0);
			contactService.updateObject(contact);
			response.sendRedirect("admin!showContact.action");
		}
	}

	/**
	 * 修改指定联系信息
	 * 
	 * @throws IOException
	 */
	public int modiId5;
	public String ctPhone1;
	public String ctFax1;
	public String ctEmail1;
	public String ctAdress1;
	public void modifyContact() throws IOException {
		ctPhone1 = new String(ctPhone1.getBytes("ISO-8859-1"), "UTF-8");
		ctFax1 = new String(ctFax1.getBytes("ISO-8859-1"), "UTF-8");
		ctEmail1 = new String(ctEmail1.getBytes("ISO-8859-1"), "UTF-8");
		ctAdress1 = new String(ctAdress1.getBytes("ISO-8859-1"), "UTF-8");
		Contact contact = contactService.findById(modiId5);
		contact.setCtPhone(ctPhone1);
		contact.setCtFax(ctFax1);
		contact.setCtEmail(ctEmail1);
		contact.setCtAdress(ctAdress1);
		contactService.updateObject(contact);
		response.sendRedirect("admin!showContact.action");
	}

	/**
	 * 删除指定联系信息
	 * 
	 * @throws IOException
	 */
	public int selcId10;
	public void deleteContact() throws IOException {
		contactService.execDelete("contact", selcId10, "ctId");
		response.sendRedirect("admin!showContact.action");
	}

	/**
	 * 显示图片
	 */
	public void showImage() {
		List<Image> images = imageService.findAll();
		request.setAttribute("images", images);
		this.forward("showImage.jsp");
	}

	/**
	 * 新增图片
	 * 
	 * @throws IOException
	 */
	public File img;// 客户端的文件对象
	public String imgFileName;// 文件名 xxxFileName
	public String imgDetail;
	public String imgType;
	public void addImage() throws IOException {
		String path = ServletActionContext.getServletContext()
				.getRealPath("/WEB-INF").substring(0, length + 7)
				+ "/docs/upload";
		String newName = System.currentTimeMillis() + ""
				+ imgFileName.substring(imgFileName.lastIndexOf("."));

		File file = new File(path + "\\" + newName);

		OutputStream os = new FileOutputStream(file);

		InputStream is = new FileInputStream(img);

		for (int i = 0; i < img.length(); i++) {

			int num = is.read();
			os.write(num);

		}

		int wideth = 0, height = 0;
		try {
			File _file = new File(path + "\\" + newName); // 读入文件
			Image src = javax.imageio.ImageIO.read(_file); // 构造Image对象
			wideth = src.getWidth(null); // 得到源图宽
			height = src.getHeight(null); // 得到源图长
		} catch (Exception e) {
			e.printStackTrace();
		}

		is.close();
		os.close();

		com.mlnxMS.core.Image image = new com.mlnxMS.core.Image();
		image.setImgUrl(newName);
		image.setImgDetail(imgDetail);
		image.setImgSize(wideth + "px*" + height + "px");
		image.setImgType(imgType);
		image.setImgStatus(0);
		image.setImgPosition(1);
		imageService.save(image);
		response.sendRedirect("admin!showImage.action");
	}

	/**
	 * 更改指定图片的使用状态
	 * 
	 * @throws IOException
	 */
	public int status11;
	public int currId11;
	public void changeImage() throws IOException {
		// 准备启用指定图片
		if (status11 == 0) {
			com.mlnxMS.core.Image image = imageService.findById(currId11);
			image.setImgStatus(1);
			imageService.updateObject(image);
			response.sendRedirect("admin!showImage.action");
			// 准备禁用指定图片
		} else {
			com.mlnxMS.core.Image image = imageService.findById(currId11);
			image.setImgStatus(0);
			imageService.updateObject(image);
			response.sendRedirect("admin!showImage.action");
		}
	}

	/**
	 * 修改指定图片信息
	 * 
	 * @throws IOException
	 */
	public int modiId6;
	public String imgDetail1;
	public String imgType1;
	public int imgPosition1;
	public void modifyImage() throws IOException {
		imgDetail1 = new String(imgDetail1.getBytes("ISO-8859-1"), "UTF-8");
		imgType1 = new String(imgType1.getBytes("ISO-8859-1"), "UTF-8");
		com.mlnxMS.core.Image image = imageService.findById(modiId6);
		image.setImgDetail(imgDetail1);
		image.setImgType(imgType1);
		image.setImgPosition(imgPosition1);
		imageService.updateObject(image);
		response.sendRedirect("admin!showImage.action");
	}

	/**
	 * 删除指定图片
	 * 
	 * @throws IOException
	 */
	public int selcId11;
	public void deleteImage() throws IOException {
		String path = ServletActionContext.getServletContext()
				.getRealPath("/WEB-INF").substring(0, length + 7)
				+ "/docs/upload";
		File file = new File(path + "\\"
				+ imageService.findById(selcId11).getIid());
		file.delete();
		contactService.execDelete("image", selcId11, "iid");
		response.sendRedirect("admin!showImage.action");
	}

	/**
	 * 显示所有用户
	 */
	public void showUser() {
		List<User> users = userService.findAll();
		request.setAttribute("users", users);
		this.forward("showUser.jsp");
	}

	/**
	 * 更改用户的使用状态
	 * 
	 * @throws IOException
	 */
	public int status12;
	public int currId12;
	public void changeUser() throws IOException {
		// 准备解封指定用户
		if (status12 == 0) {
			User user = userService.findById(currId12);
			user.setUstatus(1);
			userService.updateObject(user);
			response.sendRedirect("admin!showUser.action");
			// 准备停封指定用户
		} else {
			User user = userService.findById(currId12);
			user.setUstatus(0);
			userService.updateObject(user);
			response.sendRedirect("admin!showUser.action");
		}
	}

	/**
	 * 显示所有帖子
	 */
	public void showPost() {
		List<Post> posts = postService.findAll();
		request.setAttribute("posts", posts);
		this.forward("showPost.jsp");
	}

	/**
	 * 显示指定帖子详细内容
	 */
	public int postId;
	public void showPoContent() {
		Post post = postService.findById(postId);
		request.setAttribute("post", post);
		this.forward("showPoContent.jsp");
	}

	/**
	 * 更改指定帖子的置顶状态
	 * 
	 * @throws IOException
	 */
	public int status13;
	public int currId13;
	public void changePost() throws IOException {
		// 准备解封指定用户
		if (status13 == 0) {
			Post post = postService.findById(currId13);
			post.setPoStatus(1);
			postService.updateObject(post);
			response.sendRedirect("admin!showPost.action");
			// 准备停封指定用户
		} else {
			Post post = postService.findById(currId13);
			post.setPoStatus(0);
			postService.updateObject(post);
			response.sendRedirect("admin!showPost.action");
		}
	}

	/**
	 * 删除指定帖子
	 * 
	 * @throws IOException
	 */
	public int selcId12;
	public void deletePost() throws IOException {
		postService.execDelete("post", selcId12, "poId");
		response.sendRedirect("admin!showPost.action");
	}

	/**
	 * 显示所有回复
	 */
	public void showResponse() {
		List<Response> responses = responseService.findAll();
		request.setAttribute("responses", responses);
		this.forward("showResponse.jsp");
	}

	/**
	 * 删除指定回复
	 * 
	 * @throws IOException
	 */
	public int selcId13;
	public void deleteResponse() throws IOException {
		responseService.execDelete("response", selcId13, "rpId");
		response.sendRedirect("admin!showResponse.action");
	}

	/**
	 * 显示公告
	 */
	public void showNotice() {
		List<Notice> notices = noticeService.findAll();
		request.setAttribute("notices", notices);
		this.forward("showNotice.jsp");
	}

	/**
	 * 新增公告
	 * 
	 * @throws IOException
	 */
	public String ntTitle;
	public String ntContent;
	public void addNotice() throws IOException {
		Timestamp ts = new Timestamp(new Date().getTime());
		Notice notice = new Notice();
		notice.setNtTitle(ntTitle);
		notice.setNtContent(ntContent);
		notice.setNtTime(ts);
		notice.setNtPriority(1);
		notice.setNtStatus(0);
		noticeService.save(notice);
		response.sendRedirect("admin!showNotice.action");
	}

	/**
	 * 更改指定公告的使用状态
	 * 
	 * @throws IOException
	 */
	public int status14;
	public int currId14;
	public void changeNotice() throws IOException {
		// 准备启用指定公告
		if (status14 == 0) {
			Notice notice = noticeService.findById(currId14);
			notice.setNtStatus(1);
			noticeService.updateObject(notice);
			@SuppressWarnings("unchecked")
			List<User> users = userService.findAll();
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUid().intValue() > 0) {
					Mail mail = new Mail();
					mail.setUserBySendUid(userService.findById(0));
					mail.setUserByReceiveUid(users.get(i));
					mail.setMailTitle(notice.getNtTitle());
					mail.setMailContent(notice.getNtContent());
					mail.setMstatus(0);
					mailService.save(mail);
				}
			}
			response.sendRedirect("admin!showNotice.action");
			// 准备禁用指定公告
		} else {
			Notice notice = noticeService.findById(currId14);
			notice.setNtStatus(0);
			noticeService.updateObject(notice);
			response.sendRedirect("admin!showNotice.action");
		}
	}

	/**
	 * 修改指定公告信息
	 * 
	 * @throws IOException
	 */
	public int modiId8;
	public String ntTitle1;
	public String ntContent1;
	public int ntPriority1;
	public void modifyNotice() throws IOException {
		ntTitle1 = new String(ntTitle1.getBytes("ISO-8859-1"), "UTF-8");
		ntContent1 = new String(ntContent1.getBytes("ISO-8859-1"), "UTF-8");
		Timestamp ts = new Timestamp(new Date().getTime());
		Notice notice = noticeService.findById(modiId8);
		notice.setNtTitle(ntTitle1);
		notice.setNtContent(ntContent1);
		notice.setNtPriority(ntPriority1);
		notice.setNtTime(ts);
		noticeService.updateObject(notice);
		response.sendRedirect("admin!showNotice.action");
	}

	/**
	 * 删除指定公告
	 * 
	 * @throws IOException
	 */
	public int selcId14;
	public void deleteNotice() throws IOException {
		noticeService.execDelete("notice", selcId14, "ntId");
		response.sendRedirect("admin!showNotice.action");
	}

	/**
	 * 显示所有活动
	 */
	public void showEvent() {
		List<Event> events = eventService.findAll();
		request.setAttribute("events", events);
		this.forward("showEvent.jsp");
	}

	/**
	 * 新增活动
	 * 
	 * @throws IOException
	 */
	public String eTitle;
	public String eContent;
	public void addEvent() throws IOException {
		Timestamp ts = new Timestamp(new Date().getTime());
		Event event = new Event();
		event.setEtitle(eTitle);
		event.setEcontent(eContent);
		event.setEtime(ts);
		event.setEpriority(1);
		event.setEstatus(0);
		eventService.save(event);
		response.sendRedirect("admin!showEvent.action");
	}

	/**
	 * 更改指定活动的使用状态
	 * 
	 * @throws IOException
	 */
	public int status15;
	public int currId15;
	public void changeEvent() throws IOException {
		// 准备启用指定活动
		if (status15 == 0) {
			Event event = eventService.findById(currId15);
			event.setEstatus(1);
			eventService.updateObject(event);
			response.sendRedirect("admin!showEvent.action");
			// 准备禁用指定活动
		} else {
			Event event = eventService.findById(currId15);
			event.setEstatus(0);
			eventService.updateObject(event);
			response.sendRedirect("admin!showEvent.action");
		}
	}

	/**
	 * 修改指定活动信息
	 * 
	 * @throws IOException
	 */
	public int modiId9;
	public String eTitle1;
	public String eContent1;
	public int ePriority1;
	public void modifyEvent() throws IOException {
		eTitle1 = new String(eTitle1.getBytes("ISO-8859-1"), "UTF-8");
		eContent1 = new String(eContent1.getBytes("ISO-8859-1"), "UTF-8");
		Timestamp ts = new Timestamp(new Date().getTime());
		Event event = eventService.findById(modiId9);
		event.setEtitle(eTitle1);
		event.setEcontent(eContent1);
		event.setEpriority(ePriority1);
		event.setEtime(ts);
		eventService.updateObject(event);
		response.sendRedirect("admin!showEvent.action");
	}

	/**
	 * 删除指定活动
	 * 
	 * @throws IOException
	 */
	public int selcId15;
	public void deleteEvent() throws IOException {
		eventService.execDelete("event", selcId15, "eid");
		response.sendRedirect("admin!showEvent.action");
	}

}
