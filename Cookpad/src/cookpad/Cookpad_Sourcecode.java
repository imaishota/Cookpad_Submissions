package cookpad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cookpad_Sourcecode {
  // ファイル内容をを文字列化するメソッドです。
  public static String fileToString(File file) throws IOException {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
      StringBuffer sb = new StringBuffer();
      int c;
      while ((c = br.read()) != -1) {
        sb.append((char) c);
      }
      return sb.toString();
    } finally {
      br.close();
    }
  }


  public static void main(String[] args) throws IOException {
	  //ファイルの指定
    String s = fileToString(new File("data/cookpad_kadai.md"));

    //コマンドライン引数で指定
	System.out.println("1.大見出し、2.中見出し、3.小見出し１、4.小見出し２、数字で選択してください＞");


	String str = s;
	int num = Integer.parseInt(args[0]);


	String Heading1 = "#"; //大見出し
	String Heading2 = "##"; //中見出し
	String Heading3 = "###作り方"; //小見出し1
	String Heading4 = "###コツ・ポイント"; //小見出し2

	//表示
	if (num == 1){
		int result = str.indexOf(Heading1);
		if (result != -1) {
		    System.out.println(str.substring(result));
		} else {
		    System.out.println(Heading1 + "は見つかりませんでした");
		}
	}
	else  if (num == 2){
		int result = str.indexOf(Heading2);
		if (result != -1) {
		    System.out.println(str.substring(result));
		} else {
		    System.out.println(Heading2 + "は見つかりませんでした");
		}
	}
	else if (num == 3){
		int result = str.indexOf(Heading3);
		int result2 = str.indexOf(Heading4);
		if (result != -1) {
		    System.out.println(str.substring(result,result2));
		} else {
		    System.out.println(Heading3 + "は見つかりませんでした");
		}
	}
	else if (num == 4){
		int result = str.indexOf(Heading4);
		if (result != -1) {
		    System.out.println(str.substring(result));
		} else {
		    System.out.println(Heading4 + "は見つかりませんでした");
		}
	}
	else{
		System.out.println(""); //該当する見出しが無いので何も表示しない
	}
}
}