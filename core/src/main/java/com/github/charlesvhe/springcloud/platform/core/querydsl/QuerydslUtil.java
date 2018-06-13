package com.github.charlesvhe.springcloud.platform.core.querydsl;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.sql.RelationalPathBase;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;

public class QuerydslUtil {

    public static Predicate[] buildWhere(RelationalPathBase pathBase, Object example) throws ReflectiveOperationException {
        ArrayList<Predicate> predicateList = new ArrayList<>();

        for (Object column : pathBase.getColumns()) {
            if (column instanceof StringPath) {
                StringPath path = (StringPath) column;
                String property = path.getMetadata().getName();

                PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(example.getClass(), property);
                if (null != pd) {
                    String value = (String) pd.getReadMethod().invoke(example);
                    if (null != value) {
                        predicateList.add(path.containsIgnoreCase(value));
                    }
                }
            } else if (column instanceof NumberPath) {
                NumberPath path = (NumberPath) column;
                String property = path.getMetadata().getName();

                PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(example.getClass(), property);
                if (null != pd) {
                    Object value = pd.getReadMethod().invoke(example);
                    if (null != value) {
                        predicateList.add(path.eq(value));
                    }
                }
            }
        }

        return predicateList.toArray(new Predicate[predicateList.size()]);
    }
}
