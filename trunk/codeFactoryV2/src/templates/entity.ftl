package ${base_packge}.${type_model};

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* @TableName: ${tablename} 
* @Package: ${base_packge}.${type_model}
* @Title:${entityName}.java 
* @Description: ${table_description} 
* @author: ${author}
* @date: ${current_now}
* @version V1.0    
* create by codeFactory
*/
@Entity
@Table(name="${tablename}")
public class ${entityName}{
	<#list fieldNames as field>
	/**
	*@Fields ${field} :${remaks[field_index]}
	*/
	<#if field == primary_colmun>
	@Id
	</#if>
	@Column(name="${table_filelds[field_index]}")
	private ${filedTypes[field_index]} ${field};
	</#list>
	<#list fieldNames as field>
	public void set${field?cap_first}(${filedTypes[field_index]} ${field?uncap_first}){
		this.${field?uncap_first}=${field?uncap_first};
	}

	public ${filedTypes[field_index]} get${field?cap_first}(){
		return ${field?uncap_first};
	}
	</#list>

	public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("GAdmin[");
	<#list fieldNames as field>
	if(null != ${field?uncap_first} && !"".equals(${field?uncap_first}) ){
		sb.append("${field?uncap_first}= "+${field?uncap_first}+",");
	}
	</#list>
	sb.append("]");
	String toStr =sb.toString();
	return toStr.substring(0,toStr.indexOf(",]"))+"]";
	}

}

