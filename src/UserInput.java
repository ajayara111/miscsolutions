public class UserInput {
    
  public static class TextInput {
     String input = "";
     String output = "";
    public void add(char ch)
    {
        this.input = this.input+ch;
    }
    public String getValue(){
        
        return this.input;
    
    }
    
}

  public static class NumericInput extends TextInput {
    public void add(char ch)
    {
        
        if(Character.isDigit(ch))
        {
            super.input = super.input + ch;
        }
    }
    



    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        input.add('0');
        input.add('h');
        System.out.println(input.getValue());
    }
}
}
