package com.github.charlesvhe.springcloud.platform.support.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QConfigItem is a Querydsl query type for ConfigItem
 */
@Generated("com.github.charlesvhe.springcloud.platform.core.querydsl.MyMetaDataSerializer")
public class QConfigItem extends com.querydsl.sql.RelationalPathBase<ConfigItem> {

    private static final long serialVersionUID = -276983891;

    public static final QConfigItem qConfigItem = new QConfigItem("config_item");

    public final StringPath appId = createString("appId");

    public final StringPath code = createString("code");

    public final DateTimePath<java.util.Date> datetime1 = createDateTime("datetime1", java.util.Date.class);

    public final DateTimePath<java.util.Date> datetime2 = createDateTime("datetime2", java.util.Date.class);

    public final DateTimePath<java.util.Date> datetime3 = createDateTime("datetime3", java.util.Date.class);

    public final NumberPath<java.math.BigDecimal> decimal1 = createNumber("decimal1", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> decimal2 = createNumber("decimal2", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> decimal3 = createNumber("decimal3", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> decimal4 = createNumber("decimal4", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> decimal5 = createNumber("decimal5", java.math.BigDecimal.class);

    public final DateTimePath<java.util.Date> gmtCreate = createDateTime("gmtCreate", java.util.Date.class);

    public final DateTimePath<java.util.Date> gmtModified = createDateTime("gmtModified", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath metaCode = createString("metaCode");

    public final StringPath parentCode = createString("parentCode");

    public final NumberPath<Short> sort = createNumber("sort", Short.class);

    public final StringPath text1 = createString("text1");

    public final StringPath text2 = createString("text2");

    public final StringPath text3 = createString("text3");

    public final StringPath varchar1 = createString("varchar1");

    public final StringPath varchar10 = createString("varchar10");

    public final StringPath varchar2 = createString("varchar2");

    public final StringPath varchar3 = createString("varchar3");

    public final StringPath varchar4 = createString("varchar4");

    public final StringPath varchar5 = createString("varchar5");

    public final StringPath varchar6 = createString("varchar6");

    public final StringPath varchar7 = createString("varchar7");

    public final StringPath varchar8 = createString("varchar8");

    public final StringPath varchar9 = createString("varchar9");

    public final com.querydsl.sql.PrimaryKey<ConfigItem> constraint83 = createPrimaryKey(id);

    public QConfigItem(String variable) {
        super(ConfigItem.class, forVariable(variable), "public", "config_item");
        addMetadata();
    }

    public QConfigItem(String variable, String schema, String table) {
        super(ConfigItem.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QConfigItem(String variable, String schema) {
        super(ConfigItem.class, forVariable(variable), schema, "config_item");
        addMetadata();
    }

    public QConfigItem(Path<? extends ConfigItem> path) {
        super(path.getType(), path.getMetadata(), "public", "config_item");
        addMetadata();
    }

    public QConfigItem(PathMetadata metadata) {
        super(ConfigItem.class, metadata, "public", "config_item");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(appId, ColumnMetadata.named("app_id").withIndex(2).ofType(Types.VARCHAR).withSize(64).notNull());
        addMetadata(code, ColumnMetadata.named("code").withIndex(4).ofType(Types.VARCHAR).withSize(128).notNull());
        addMetadata(datetime1, ColumnMetadata.named("datetime1").withIndex(25).ofType(Types.TIMESTAMP).withSize(26).withDigits(6).notNull());
        addMetadata(datetime2, ColumnMetadata.named("datetime2").withIndex(26).ofType(Types.TIMESTAMP).withSize(26).withDigits(6).notNull());
        addMetadata(datetime3, ColumnMetadata.named("datetime3").withIndex(27).ofType(Types.TIMESTAMP).withSize(26).withDigits(6).notNull());
        addMetadata(decimal1, ColumnMetadata.named("decimal1").withIndex(20).ofType(Types.DECIMAL).withSize(19).withDigits(4).notNull());
        addMetadata(decimal2, ColumnMetadata.named("decimal2").withIndex(21).ofType(Types.DECIMAL).withSize(19).withDigits(4).notNull());
        addMetadata(decimal3, ColumnMetadata.named("decimal3").withIndex(22).ofType(Types.DECIMAL).withSize(19).withDigits(4).notNull());
        addMetadata(decimal4, ColumnMetadata.named("decimal4").withIndex(23).ofType(Types.DECIMAL).withSize(19).withDigits(4).notNull());
        addMetadata(decimal5, ColumnMetadata.named("decimal5").withIndex(24).ofType(Types.DECIMAL).withSize(19).withDigits(4).notNull());
        addMetadata(gmtCreate, ColumnMetadata.named("gmt_create").withIndex(28).ofType(Types.TIMESTAMP).withSize(26).withDigits(6).notNull());
        addMetadata(gmtModified, ColumnMetadata.named("gmt_modified").withIndex(29).ofType(Types.TIMESTAMP).withSize(26).withDigits(6).notNull());
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(metaCode, ColumnMetadata.named("meta_code").withIndex(3).ofType(Types.VARCHAR).withSize(64).notNull());
        addMetadata(parentCode, ColumnMetadata.named("parent_code").withIndex(5).ofType(Types.VARCHAR).withSize(128).notNull());
        addMetadata(sort, ColumnMetadata.named("sort").withIndex(6).ofType(Types.SMALLINT).withSize(5).notNull());
        addMetadata(text1, ColumnMetadata.named("text1").withIndex(17).ofType(Types.CLOB).withSize(2147483647));
        addMetadata(text2, ColumnMetadata.named("text2").withIndex(18).ofType(Types.CLOB).withSize(2147483647));
        addMetadata(text3, ColumnMetadata.named("text3").withIndex(19).ofType(Types.CLOB).withSize(2147483647));
        addMetadata(varchar1, ColumnMetadata.named("varchar1").withIndex(7).ofType(Types.VARCHAR).withSize(512).notNull());
        addMetadata(varchar10, ColumnMetadata.named("varchar10").withIndex(16).ofType(Types.VARCHAR).withSize(512).notNull());
        addMetadata(varchar2, ColumnMetadata.named("varchar2").withIndex(8).ofType(Types.VARCHAR).withSize(512).notNull());
        addMetadata(varchar3, ColumnMetadata.named("varchar3").withIndex(9).ofType(Types.VARCHAR).withSize(512).notNull());
        addMetadata(varchar4, ColumnMetadata.named("varchar4").withIndex(10).ofType(Types.VARCHAR).withSize(512).notNull());
        addMetadata(varchar5, ColumnMetadata.named("varchar5").withIndex(11).ofType(Types.VARCHAR).withSize(512).notNull());
        addMetadata(varchar6, ColumnMetadata.named("varchar6").withIndex(12).ofType(Types.VARCHAR).withSize(512).notNull());
        addMetadata(varchar7, ColumnMetadata.named("varchar7").withIndex(13).ofType(Types.VARCHAR).withSize(512).notNull());
        addMetadata(varchar8, ColumnMetadata.named("varchar8").withIndex(14).ofType(Types.VARCHAR).withSize(512).notNull());
        addMetadata(varchar9, ColumnMetadata.named("varchar9").withIndex(15).ofType(Types.VARCHAR).withSize(512).notNull());
    }

}

