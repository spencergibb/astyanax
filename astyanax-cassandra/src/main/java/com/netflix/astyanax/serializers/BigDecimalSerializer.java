package com.netflix.astyanax.serializers;

import java.math.BigDecimal;
import java.nio.ByteBuffer;

import org.apache.cassandra.cql.jdbc.JdbcDecimal;
import org.apache.cassandra.db.marshal.DecimalType;

public class BigDecimalSerializer extends AbstractSerializer<BigDecimal> {

    private static final BigDecimalSerializer INSTANCE = new BigDecimalSerializer();

    public static BigDecimalSerializer get() {
        return INSTANCE;
    }

    @Override
    public BigDecimal fromByteBuffer(ByteBuffer byteBuffer) {
        return JdbcDecimal.instance.compose(byteBuffer.duplicate());
    }

    @Override
    public ByteBuffer toByteBuffer(BigDecimal obj) {
        return JdbcDecimal.instance.decompose(obj);
    }

    @Override
    public ComparatorType getComparatorType() {
        return ComparatorType.DECIMALTYPE;
    }

    @Override
    public ByteBuffer fromString(String str) {
        return DecimalType.instance.fromString(str);
    }

    @Override
    public String getString(ByteBuffer byteBuffer) {
        return DecimalType.instance.getString(byteBuffer);
    }

    @Override
    public ByteBuffer getNext(ByteBuffer byteBuffer) {
        throw new RuntimeException("Not supported");
    }

}
