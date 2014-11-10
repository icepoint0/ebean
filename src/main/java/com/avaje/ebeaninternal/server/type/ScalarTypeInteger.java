package com.avaje.ebeaninternal.server.type;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;

import com.avaje.ebean.text.TextException;
import com.avaje.ebeaninternal.server.core.BasicTypeConverter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/**
 * ScalarType for Integer and int.
 */
public class ScalarTypeInteger extends ScalarTypeBase<Integer> {

	public ScalarTypeInteger() {
		super(Integer.class, true, Types.INTEGER);
	}
	
	public void bind(DataBind b, Integer value) throws SQLException {
		if (value == null){
			b.setNull(Types.INTEGER);
		} else {
			b.setInt(value.intValue());
		}
	}

	public Integer read(DataReader dataReader) throws SQLException {
		
		return dataReader.getInt();
	}

    public Object readData(DataInput dataInput) throws IOException {
        return Integer.valueOf(dataInput.readInt());
    }

    public void writeData(DataOutput dataOutput, Object v) throws IOException {
        dataOutput.writeInt((Integer) v);
    }
	
	public Object toJdbcType(Object value) {
		return BasicTypeConverter.toInteger(value);
	}

	public Integer toBeanType(Object value) {
		return BasicTypeConverter.toInteger(value);
	}

    public String formatValue(Integer v) {
        return v.toString();
    }

	public Integer parse(String value) {
		return Integer.valueOf(value);
	}

	public Integer parseDateTime(long systemTimeMillis) {
		throw new TextException("Not Supported");
	}

	public boolean isDateTimeCapable() {
		return false;
	}
    
  @Override
  public Object jsonRead(JsonParser ctx, JsonToken event) throws IOException {
    return ctx.getIntValue();
  }

  public void jsonWrite(JsonGenerator ctx, String name, Object value) throws IOException {
    ctx.writeNumberField(name, (Integer) value);
  }
}
