package com.example.mapper;

import com.example.model.Item;
import com.example.model.ItemExample.Criteria;
import com.example.model.ItemExample.Criterion;
import com.example.model.ItemExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ItemSqlProvider {

    public String countByExample(ItemExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("item");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ItemExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("item");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Item record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("item");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getOrderid() != null) {
            sql.VALUES("orderid", "#{orderid,jdbcType=INTEGER}");
        }
        
        if (record.getProid() != null) {
            sql.VALUES("proid", "#{proid,jdbcType=INTEGER}");
        }
        
        if (record.getShopname() != null) {
            sql.VALUES("shopname", "#{shopname,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            sql.VALUES("num", "#{num,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ItemExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("orderid");
        sql.SELECT("proid");
        sql.SELECT("shopname");
        sql.SELECT("num");
        sql.SELECT("price");
        sql.FROM("item");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Item record = (Item) parameter.get("record");
        ItemExample example = (ItemExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("item");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getOrderid() != null) {
            sql.SET("orderid = #{record.orderid,jdbcType=INTEGER}");
        }
        
        if (record.getProid() != null) {
            sql.SET("proid = #{record.proid,jdbcType=INTEGER}");
        }
        
        if (record.getShopname() != null) {
            sql.SET("shopname = #{record.shopname,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            sql.SET("num = #{record.num,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("item");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("orderid = #{record.orderid,jdbcType=INTEGER}");
        sql.SET("proid = #{record.proid,jdbcType=INTEGER}");
        sql.SET("shopname = #{record.shopname,jdbcType=VARCHAR}");
        sql.SET("num = #{record.num,jdbcType=INTEGER}");
        sql.SET("price = #{record.price,jdbcType=DECIMAL}");
        
        ItemExample example = (ItemExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Item record) {
        SQL sql = new SQL();
        sql.UPDATE("item");
        
        if (record.getOrderid() != null) {
            sql.SET("orderid = #{orderid,jdbcType=INTEGER}");
        }
        
        if (record.getProid() != null) {
            sql.SET("proid = #{proid,jdbcType=INTEGER}");
        }
        
        if (record.getShopname() != null) {
            sql.SET("shopname = #{shopname,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            sql.SET("num = #{num,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ItemExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}