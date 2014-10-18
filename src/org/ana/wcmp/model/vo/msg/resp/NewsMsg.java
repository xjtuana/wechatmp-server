package org.ana.wcmp.model.vo.msg.resp;

/**
 * ͼ����Ϣ�࣬���ж���ͼ�ģ�������10���һ��Ĭ��Ϊ��ͼ��ͷ�����ţ�����ͼ��������List<>������һ����󣩣���Ϣ������
 * ͼ��������ArticleCount   ͼ�������飺Articles
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class NewsMsg extends CommonInfoResp{

	private int ArticleCount;
	private Article[] Articles;
	
	public int getArticleCount(){
		return ArticleCount;
	}
	
	public Article[] getArticles(){
		return Articles;
	}
	
	public void setArticleCount(int newarticlecount){
		ArticleCount = newarticlecount;
	}
	
	public void setArticles(Article[] newarticles){
		Articles = newarticles;
	}
}
