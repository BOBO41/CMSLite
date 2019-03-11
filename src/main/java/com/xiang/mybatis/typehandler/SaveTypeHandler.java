package com.xiang.mybatis.typehandler;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class SaveTypeHandler implements TypeHandler<Object> {

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		if (Objects.isNull(parameter)) {
			switch (jdbcType) {
			case BIT:
				parameter = 0;
				break;
			case TINYINT:
				parameter = 0;
				break;
			case SMALLINT:
				parameter = 0;
				break;
			case INTEGER:
				parameter = 0;
				break;
			case BIGINT:
				parameter = 0;
				break;
			case FLOAT:
				parameter = 0f;
				break;
			case REAL:
				parameter = 0f;
				break;
			case DOUBLE:
				parameter = 0d;
				break;
			case NUMERIC:
				parameter = new BigDecimal(0);
				break;
			case DECIMAL:
				parameter = new BigDecimal(0);
				break;
			case CHAR:
				parameter = "";
				break;
			case VARCHAR:
				parameter = "";
				break;
			case LONGVARCHAR:
				parameter = "";
				break;
			case DATE:
				parameter = new Date();
				break;
			case TIME:
				parameter = new Date();
				break;
			case TIMESTAMP:
				parameter = new Date();
				break;
			case BOOLEAN:
				parameter = false;
				break;
			default:
				break;
			}
		}
		ps.setObject(i, parameter);
	}

	@Override
	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return rs.getObject(columnName);
	}

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return rs.getObject(columnIndex);
	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return cs.getObject(columnIndex);
	}
}
