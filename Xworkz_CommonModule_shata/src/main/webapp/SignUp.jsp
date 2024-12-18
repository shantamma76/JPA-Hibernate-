<%@page isELIgnored = "false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course Form Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .form-container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <!-- Card for the form -->
        <div class="card shadow-lg form-container">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">Sign Up Form</h2>
                <form action="signup" method="post">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name" required>
                    </div>

                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email" required>
                    </div>

                    <div class="mb-3">
                        <label for="phoneNo" class="form-label">Phone Number</label>
                        <input type="number" class="form-control" id="phoneNo" name="phone" placeholder="Enter Phone Number" pattern="[0-9]{10}" required>
                    </div>

                     <div class="mb-3">
                          <label for="email" class="form-label">Alter Email</label>
                          <input type="email" class="form-control" id="email" name="alterEmail" placeholder="Enter Alter Email" required>
                     </div>

                        <div class="mb-3">
                              <label for="phoneNo" class="form-label">Alternate Phone Number</label>
                              <input type="number" class="form-control" id="phoneNo" name="alterPhone" placeholder="Enter Alter Number" required>
                         </div>

                        <div class="mb-3">
                        <label for="location" class="form-label">Location</label>
                                <input type="text" class="form-control" id="location" name="location" placeholder="Enter Location" required>
                         </div>

                    <button type="submit" class="btn btn-info w-100">Login</button>
                </form>
            </div>
        </div>

    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


