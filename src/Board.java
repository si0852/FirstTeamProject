import java.util.Scanner;


public class Board {

	public static void main(String[] args) {
		
		String[][] boardArray = new String[100][5];
		String[] replaceArray = new String[101];
		String boardContent = ""; // 생성시 게시판 내용 저장할 변수
		
		String boardNum = ""; // input 번호
		String updatecontent = ""; //update 번호 입력
		String input = "";/// 목록 번호 입력
		
		int index = 1; // 게시판 번호 인덱스
		
		
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("1. 목록 | 2. 생성(Create) | 3. 읽기(Read) | 4. 수정(Update) | 5. 삭제(Delete) | 6. 종료 ");
			System.out.println("----------------------------------------------------------------------------------");
			input = scanner.nextLine();
			String title = "";
			String content = "";
			String writer = "";
			
			if(input.equals("1")) {
				int count = 0;
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("\t번호\t제목\t내용\t글쓴이\t조회\t");
				System.out.println("-----------------------------------------------------------------------------");
				for(int i=index; i>0; i--) {
					if(replaceArray[i]!=null) {
					for(int j=0; j<5; j++) {
						
						boardContent += " \t " + boardArray[Integer.parseInt(replaceArray[i])][j]; 
						count++;
						
					}
					System.out.println(boardContent);
					boardContent = "";
				  }
				}
				
				if(count == 0) {
					System.out.println("게시된 글이 없습니다.");
				}
			}else if(input.equals("2")) {
				System.out.print("제목 : ");
				title = scanner.nextLine();
				System.out.print("내용 : ");
				content = scanner.nextLine();
				System.out.print("글쓴이 : ");
				writer = scanner.nextLine();
				
				
				for(int i=0; i<index; i++) {
					if(boardArray[i][0] == null) {
							boardArray[i][0]= String.valueOf(index);
							replaceArray[Integer.parseInt(boardArray[i][0])] = String.valueOf(i);
							boardArray[i][1]= title;
							boardArray[i][2]= content;
							boardArray[i][3]= writer;
							boardArray[i][4]= String.valueOf(0);
							//replaceArray[index] = String.valueOf(i);
							index++;
							break;
					}
				}
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("\t번호\t제목\t내용\t글쓴이\t조회\t");
				System.out.println("-----------------------------------------------------------------------------");
				for(int i=index; i>0; i--) {
					if(replaceArray[i]!=null) {
					for(int j=0; j<5; j++) {
						
						boardContent += " \t " + boardArray[Integer.parseInt(replaceArray[i])][j]; 
						
					}
					System.out.println(boardContent);
					boardContent = "";
				  }
				}
				
			}else if(input.equals("3")) {
				boardNum = "";
				System.out.print("번호 : ");
				boardNum = scanner.nextLine();
				int temp = 0;
				
				for(int i=0; i<index; i++) {
					if(boardNum.equals(boardArray[i][0])) {
						System.out.println("제목  : " + boardArray[Integer.parseInt(boardNum)-1][1]);
						System.out.println("내용  : " + boardArray[Integer.parseInt(boardNum)-1][2]);
						System.out.println("글쓴이 : " + boardArray[Integer.parseInt(boardNum)-1][3]);
						int count = Integer.parseInt(boardArray[Integer.parseInt(boardNum)-1][4]) + 1;
						boardArray[Integer.parseInt(boardNum)-1][4] = String.valueOf(count);
						System.out.println("조회수 : " +boardArray[Integer.parseInt(boardNum)-1][4] );
						temp++;
						break;
					}
				}
				
				if(temp == 0) {
					System.out.println("해당 글이 없습니다.");
				}
				
				
			}else if(input.equals("4")) {
				int num = 0;
				int count = 0;
				System.out.print("번호 : ");
				boardNum = scanner.nextLine();
				for(int i=0; i<index; i++) {
					if(boardNum.equals(boardArray[i][0])) {
						count ++;
						num = i;
						System.out.println("기존제목  : " + boardArray[num][1]);
						System.out.print("수정제목  : ");
						updatecontent =scanner.nextLine();
						if(!updatecontent.equals("")) {
							boardArray[num][1] = updatecontent;
							updatecontent = "";
						}else {
							System.out.println();
						}
						System.out.println("기존내용  : " + boardArray[num][2]);
						System.out.print("수정내용  : ");
						updatecontent =scanner.nextLine();
						if(!updatecontent.equals("")) {
							boardArray[num][2] = updatecontent;
							updatecontent = "";
						}else {
							System.out.println();
						}
						
						System.out.println("-----------------------------------------------------------------------------");
						System.out.println("\t번호\t제목\t내용\t글쓴이\t조회\t");
						System.out.println("-----------------------------------------------------------------------------");
						for(int l=index; l>0; l--) {
							if(replaceArray[l]!=null) {
							for(int j=0; j<5; j++) {
								
								boardContent += " \t " + boardArray[Integer.parseInt(replaceArray[l])][j]; 
								
							}
							System.out.println(boardContent);
							boardContent = "";
						  }
						}
						break;
					}else {
						
						continue;
					}
				}
				if(count == 0) {
					System.out.println("해당 글이 없습니다.");
				}

			}else if(input.equals("5")) {
				System.out.print("번호 : ");
				boardNum = scanner.nextLine();
				//int k = Integer.parseInt(boardNum);
				
				for(int i=0; i<index; i++) {
					if(boardNum.equals(boardArray[i][0])) {
						replaceArray[Integer.parseInt(boardArray[i][0])] = null;
						boardArray[i][0] = null;
					}else {
						System.out.println("해당 글이 없습니다.");
					}
				}
				
					//System.out.println("what : " + Integer.parseInt(boardArray[k-1][0]));
					
				
				
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("\t번호\t제목\t내용\t글쓴이\t조회\t");
				System.out.println("-----------------------------------------------------------------------------");
				for(int i=index; i>0; i--) {
					if(replaceArray[i]!=null) {
					for(int j=0; j<5; j++) {
						
						boardContent += " \t " + boardArray[Integer.parseInt(replaceArray[i])][j]; 
						
					}
					System.out.println(boardContent);
					boardContent = "";
				  }
				}
			}else if(input.equals("6")) {
				for(int i=0; i<7; i++) {
					System.out.println("게시판 번호 : " + boardArray[i][0]);
				}
				break;
			}else {
				System.out.println("다시 입력해주세요");
			}
			
		}
	}

}
