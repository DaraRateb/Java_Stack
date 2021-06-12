class ProjectTest {
    public static void main(String[] args) {
        Project python = new Project();
        Project java = new Project();
        python.setName("BlackBelt");
        python.setDescription("Final Project");
        String pythonname = python.getName();
        String pythondescription = python.getDescription();
        java.setName("RedBelt");
        java.setDescription("Importante Project");
        String javaname = java.getName();
        String javadescription = java.getDescription();
        System.out.println("Python Project - name: " + pythonname + ". Python Project - description: " + pythondescription);
        System.out.println("Java Project - name: " + javaname + ". Java Project - description: " + javadescription);
    }
}