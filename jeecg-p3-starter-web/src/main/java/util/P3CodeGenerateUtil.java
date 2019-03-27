package util;

import org.jeecgframework.p3.cg.def.FtlDef;
import org.jeecgframework.p3.cg.factory.CodeGenerateFactory;

/**
 * 描述：代码生成器工具类（支持单表）
 * 
 * @author：zhoujf
 * @since：
 * @version:1.0
 */
public class P3CodeGenerateUtil {

	public static void main(String[] args) {
		//表名（多个表可用逗号隔开）
		String code_cg_tables = "f_d_goods";
		
		//执行代码生成器
		for (String tableName : code_cg_tables.split(",")) {
			CodeGenerateFactory.codeGenerateByFTL(tableName, "商品表", FtlDef.KEY_TYPE_02);
		}
	}
}
