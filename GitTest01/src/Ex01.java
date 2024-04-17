import Game.SentenceGame;


public class Ex01 {
	public static void main(String[] args) {
		
		System.out.println("팀장 첫번째 커밋! 수정");
		System.out.println("팀원1 두번째 커밋");
		System.out.println("팀원3 네번째 커밋!");
		System.out.println("팀원4 네번째 커밋!");
		System.out.println("팀원5 커밋");
		

		//String str = "⣿⣿⣿⣿⠿⠿⠿⢿⡿⠿⠿⠿⢿⣿⣿⣿\n⣿⣿⣿⡇ ⣤⣤⣤⡇⠀⣤⣤⣤⣿⣿⣿\n⣿⣿⣿⣇ ⠉⠉⠉⡇⠀⠉⠉⠉⣿⣿⣿\n⣿⣿⣿⠿⠿⠿⠿⠀ ⠿ ⠿⠿⠿⣿⣿\n⣿⣿⣿⣤⣤⣤⠤⠤⠤⠤⢤⣤⣤⣿⣿⣿\n⣿⣿⣿⣿⠉⠀⣤⣤⣤⣤⡀⠈⢻⣿⣿⣿\n⣿⣿⣿⣿⣄⡀⠉⠙⠛⠉⠁⣠⣾⣿⣿⣿\n⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿";
		//Util.print(str);
		SentenceGame view = new SentenceGame();
		view.Play();
	}
}
