class EmployeeIdGenerator {
    public String generateEmpId(String firstName) {
        return firstName.substring(0, 3).toUpperCase() + System.currentTimeMillis() % 1000;
    }
}