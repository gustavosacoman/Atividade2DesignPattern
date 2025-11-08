import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ValidationContext {
    private DocumentsNFE nfe;
    private List<String> errors = new ArrayList<>();
    private Stack<Runnable> rollbackActions = new Stack<>();

    public ValidationContext(DocumentsNFE nfe) 
    { 
        this.nfe = nfe; 
    }

    public void addError(String error) 
    {
         this.errors.add(error); 
    }

    public boolean hasErrors() 
    { 
        return !this.errors.isEmpty();
    }
    public int getErrorCount() 
    { 
        return this.errors.size(); 
    }
    public Stack<Runnable> getRollbackActions() 
    { 
        return this.rollbackActions; 
    }
    public DocumentsNFE getNfe() 
    { 
        return this.nfe; 
    }
    public List<String> getErrors() 
    { 
        return this.errors; 
    }
}