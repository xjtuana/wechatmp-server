package org.ana.wcmp.model.msgVO.resp;

import java.util.List;

/**
 * ͼ����Ϣ�࣬���ж���ͼ�ģ�������10���һ��Ĭ��Ϊ��ͼ��ͷ�����ţ�����ͼ��������List<>������һ����󣩣���Ϣ������
 * ͼ��������ArticleCount   ͼ�������飨List��ʽ����Articles
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class NewsMsg extends CommonInfoResp{

	private int ArticleCount;
	private List<Article> Articles;
	
	public int getArticleCount(){
		return ArticleCount;
	}
	
	public List<Article> getArticles(){
		return Articles;
	}
	
	public void setArticleCount(int newarticlecount){
		ArticleCount = newarticlecount;
	}
	
	public void setArticles(List<Article> newarticles){
		Articles = newarticles;
	}
}
