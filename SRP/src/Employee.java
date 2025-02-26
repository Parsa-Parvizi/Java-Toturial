class Employee {
    private String firstName;
    private String lastName;
    private double experienceInYears;

    public Employee(String firstName, String lastName, double experienceInYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceInYears = experienceInYears;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getExperienceInYears() {
        return experienceInYears;
    }

    public void displayEmpDetail() {
        System.out.println("Employee: " + firstName + " " + lastName);
        System.out.println("Experience: " + experienceInYears + " years");
    }
}