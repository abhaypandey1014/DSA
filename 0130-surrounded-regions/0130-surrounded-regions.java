class Solution {
    public void dfs(char[][] board,int i,int j){
        int n = board.length;
        int m = board[0].length;
        if(i>=n || j>=m || i<0 || j<0 || board[i][j]=='X' || board[i][j]=='Y') return;
        // if((i==n-1 || j==m-1 || i==0 || j==0) && board[i][j]=='O') return true;
        char temp = board[i][j];
        board[i][j] = 'Y';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
        // board[i][j] = temp;
        return;
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        // boolean vis[][] = new boolean[n][m];
        for(int i = 0;i<n;i++){
            if(board[i][0]=='O') dfs(board,i,0);  
            if(board[i][m-1]=='O') dfs(board,i,m-1); 
        }
        for(int i = 0;i<m;i++){
            if(board[0][i]=='O') dfs(board,0,i);  
            if(board[n-1][i]=='O') dfs(board,n-1,i); 
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j]=='Y') board[i][j] = 'O';
                else if(board[i][j]=='O') board[i][j] = 'X';
            }
        }
        return;
    }
}