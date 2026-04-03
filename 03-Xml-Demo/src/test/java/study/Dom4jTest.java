package study;

import com.study.pojo.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * ClassName: Practice01
 * Package: java001.day05
 * Description:
 * {@code @Author} Liang-ht
 * {@code @Create} 2025/9/27 14:19
 * {@code @Version} 1.0
 */

public class Dom4jTest {
	@Test
	public void test01() throws DocumentException {
		// 创建一个SaxReader输入流，读取xml配置文件，生成Document对象
		SAXReader saxReader = new SAXReader();

		Document document = saxReader.read("src/xml/01-books.xml");
		System.out.println(document);
	}

	/**
	 * 读取books.xml文件生成book类
	 */

	@Test
	public void test02() throws DocumentException {
		//1. 读取books.xml文件
		SAXReader reader = new SAXReader();
		// 在Junit测试中，相对路径是从模块名开始算的
		Document document = reader.read("src/xml/01-books.xml");

		//2. 通过Document对象获取根元素
		Element rootElement = document.getRootElement();
		//3. 通过根元素获取book标签对象
		// element和elements()方法都是通过标签名查找子元素
		List<Element> books = rootElement.elements("book");
		//4. 遍历，处理每个book标签转换为Book类
		for (Element book : books) {
			Element name = book.element("name");

			// asXML() : 把标签对象，转换为标签字符串
//			System.out.println(name.asXML());
			// getText() ： 获取标签中的文本内容
			String nameText = name.getText();
			String price = book.elementText("price");
			String author = book.elementText("author");
			// 获取属性值
			String snValue = book.attributeValue("sn");
			System.out.println(new Book(snValue,nameText,Double.parseDouble(price),author));
		}
	}
}
