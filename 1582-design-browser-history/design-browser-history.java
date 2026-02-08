class BrowserHistory {
    String[] history;
    int curr;
    int last;

    public BrowserHistory(String homepage) {
        history=new String[5000];
        history[0]=homepage;
        curr=0;
        last=0;
    }
    
    public void visit(String url) {
        curr++;
        history[curr]=url;
        last=curr;
    }

    
    public String back(int steps) {
        curr=Math.max(0,curr-steps);
        return history[curr];

    }
    
    public String forward(int steps) {
        curr=Math.min(last,curr+steps);
        return history[curr];
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */