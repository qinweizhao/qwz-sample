package com.qinweizhao.basic.pdf.sample;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import com.qinweizhao.basic.pdf.util.FontUtil;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author qinweizhao
 * @since 2023-05-06
 */

public class TextSample {


	public static void main(String[] args) {

		String fileName = "C:\\\\Users\\\\YVKG\\\\Desktop\\\\txttest.pdf";
		sample(fileName);

	}


	public static void sample(String fileName) {

		try {
			Document document = new Document();
			document.setMargins(71, 70, 20, 10);
			PdfWriter writer = PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(fileName)));

//
//			Font font = FontUtil.getFont();
//
//			HeaderFooter footer = new HeaderFooter(new Phrase("页码：",font), true);
//			footer.setAlignment(HeaderFooter.ALIGN_CENTER);
//			footer.setBorder(Rectangle.NO_BORDER);
//			document.setFooter(footer);


			document.open();


			//添加文本
			PdfContentByte cb = writer.getDirectContent();
//			BaseFont bf = FontUtil.getBaseFont();

			// 用0.1厚度的下划线创建一个块
			Chunk underline = new Chunk("The quick brown fox ");
			underline.setUnderline(0.1f, -1f);
			document.add(underline);



			// 创建厚度为1的穿墙大块
			Chunk strike = new Chunk("jumps over the lazy dog.");
			strike.setUnderline(1f, 3f);
			document.add(strike);


//
//			cb.beginText();
//			cb.setFontAndSize(bf, 12);
//			cb.setTextMatrix(50, 500);
//			cb.showText("自动换行");
//			cb.endText();
//
//			cb.beginText();
//			cb.setFontAndSize(bf, 12);
//			cb.setTextMatrix(50, 485);
//			cb.showText("测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测");
//			cb.endText();
//
//			cb.beginText();
//			cb.setFontAndSize(bf, 12);
//			cb.setTextMatrix(60, 470);
//			cb.showText("试测试测试测试测试测试测试");
//			cb.endText();


			String txt="书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。书是纯英文的，里面全是专业术语，小姜只能一边查字典，一边用翻译软件一点点啃出来。\n" +
					"\n" +
					"“其实大家天赋未必差很多，但是一个人一直在玩，一个人一直在学习，渐渐就拉开了（差距）。”\n" +
					"\n" +
					"王闰秋说，虽然刻板印象中数学好的女生不多，但实际上并不是。女生里也有特别优秀的数学家，比如德国数学家埃米·诺特就是代表之一。因为在微分不等式、环和理想子群等方面的伟大成就，影响了世界数学界，是20世纪的著名数学家。\n" +
					"\n" +
					"这次阿里巴巴数学竞赛，是王闰秋鼓励姜萍报的名，当时姜萍的第一反应是：“我也配？”\n" +
					"\n" +
					"其实闰秋本人在几年前也参加过阿里巴巴全球数学竞赛，第一次没有入围；2022年又报了名，还闯进了决赛。\n" +
					"\n" +
					"这次考完后，王闰秋特意找姜萍复盘，坐下来估了一次分。今年的题目其实有一点难，最后的入围分是40多分，也是唯一没有出现满分的一年。\n" +
					"\n" +
					"“当时估计在七八十分，没想到最后拿到了93分。”王闰秋说。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，\n" +
					"\n" +
					"痛并快乐”\n" +
					"\n" +
					"王老师本人去年也闯进了阿里数赛决赛\n" +
					"\n" +
					"王闰秋师从江苏大学数学科学学院卢殿臣教授，已参加了两届阿里巴巴全球数学竞赛。2022年预赛166名，去年预赛432名。\n" +
					"\n" +
					"2020年从江苏大学毕业后，王闰秋入职家乡这所职业高中，在教学工作之余，他依旧沉迷于基础数学研究。\n" +
					"\n" +
					"在2022年阿里巴巴全球数学竞赛中，一道左右一致的题目让王闰秋想了整整一天，在最后一刻写下证明后，他真实地感受到那个证明的对称性太美了。\n" +
					"\n" +
					"“对我来说，数学是更本质的东西，就像我戴的眼镜一样，可以提供一种全新的视角，去重新看待日常生活。”王闰秋当时说。\n" +
					"\n" +
					"虽然连续8个小时做题，难度大，很烧脑，但做研究的日常，就是在死路和死路之间切换探索，这不仅需要深厚的数学底蕴，更需要开朗和豁达的心态。\n" +
					"\n" +
					"“研究数学就像走一个很大的迷宫，可能只有一条路能通过，大部分都是死路，但这种沉浸于数学世界中的感觉，让我痛并快乐着。”\n" +
					"\n" +
					"天才少女登上《人民日报》\n" +
					"\n" +
					"杭州一家科技公司想让小姜去实习\n" +
					"\n" +
					"这个喜欢数学也喜欢服装设计的天才少女，昨天在朋友圈刷屏还登上了《人民日报》公众号，引发网友热议的同时，也受到了很多专家的关注。";




//			ColumnText ct = new ColumnText(cb);
			Chunk c1 = new Chunk(txt);
			c1.setUnderline(Color.green, 1, 0, 0, 0, 0);
			Phrase phrase = new Phrase(c1);
//			ct.setText(phrase);

			Phrase phrase1 = new Phrase(txt);
//			ct.setText(phrase1);

			document.add(phrase);
			document.add(phrase1);
//			float width = ColumnText.getWidth(phrase);
//			System.out.println("宽度为：" + width);
//			ct.setSimpleColumn(10, 330, width + 10, 450);
//			ct.setSimpleColumn(10, 330, 1000, 450);
//			ct.go();



			document.close();


			System.out.println("运行结束");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
