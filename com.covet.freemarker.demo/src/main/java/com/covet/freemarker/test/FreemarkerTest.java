package com.covet.freemarker.test;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerTest {

	// 模版+数据=静态数据
	public static void main(String[] args) throws Exception {
		// 1. 创建freemarker的核心对象
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		
		// 2. 给核心对象设置模版所在位置 (动态获取项目路径)
		cfg.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir") + "/src/ftl"));
	
		// 3. 使用核心对象,根据模版名称,获取模版对象
		Template template = cfg.getTemplate("test.avi");
		
		// 4. 准备模型数据,存放数据.官方推荐模型数据是Map类型
		Map<String, Object> root = new HashMap<>();
		
		// a.普通字符串
		root.put("name", "World");
		
		
		// b.javabean
		Person person = new Person();
		person.setId(1001);
		person.setName("张三");
		root.put("person", person);
		
		
		// c.List
		List<Person> list= new ArrayList<>();
		list.add(new Person(2002, "李四"));
		list.add(new Person(2003, "王二"));
		root.put("list", list);
		
		
		// d.Map
		Map<String, Person> map = new HashMap<>();
		map.put("m1", new Person(2004, "德玛西亚之力"));
		map.put("m2", new Person(2004, "德玛西亚之翼"));
		map.put("m3", new Person(2004, "德玛西亚之光"));
		root.put("map", map);
		
		
		// e.List<Map>
		List<Map<String, Person>> lm = new ArrayList<>();
		Map<String, Person> map1 = new HashMap<>();
		map1.put("m1", new Person(2001,"张飞"));
		map1.put("m2", new Person(2002,"关羽"));
		
		Map<String, Person> map2 = new HashMap<>();
		map2.put("m1", new Person(2001,"赵云"));
		map2.put("m2", new Person(2002,"项羽"));
		lm.add(map1);
		lm.add(map2);
		
		root.put("lm", lm);
		
		
		// f.date
		Date date = new Date();
		root.put("date", date);
		
		
		// g.null
		String test = null;
		root.put("test", test);
		// h.include
		
		
		// 5. 创建输出的Writer,创建FileWriter的子类
		Writer out = new FileWriter(new File("E:/test/test.html"));
		
		// 6. 使用模版对象输出静态页面,需要两个参数,第一个参数是需要的模型数据,第二个参数是输出的Writer对象
		template.process(root, out);
	}

}
