package xgj.mcj.entity;

import java.util.List;

/**
 * Created by hbd on 2015/10/22.
 */
public class PageModel<T> {
 
    private Integer pageNumber; //��ǰҳ��
    private Integer pageSize;   //һҳ��ʾ����
    private Integer startRow;   //��ѯ��ʼ��
    private Integer total;      //�ܼ�¼����
    private List<T> rows;       //��ѯ�������
    private T queryObj;         //��ѯ����
 
    public Integer getStartRow() {
        if(pageNumber!=null && pageSize!=null) {
            return (pageNumber - 1) * pageSize;
        } else {
            return 0;
        }
    }
 
    public Integer getPageNumber() {
        return pageNumber;
    }
 
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
 
    public Integer getPageSize() {
        return pageSize;
    }
 
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
 
    public Integer getTotal() {
        return total;
    }
 
    public void setTotal(Integer total) {
        this.total = total;
    }
 
    public List<T> getRows() {
        return rows;
    }
 
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
 
    public void setQueryObj(T queryObj) {
        this.queryObj = queryObj;
    }
 
    public T getQueryObj() {
        return queryObj;
    }
}