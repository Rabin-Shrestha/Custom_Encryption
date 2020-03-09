<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>THD ICM Encryption</title>
    <link rel="icon" type="image/png" href="favicon-16x16.png" sizes="16x16"/>
    <link rel="icon" type="image/png" href="favicon-32x32.png" sizes="32x32"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        .myBorder {
            margin-top: 5rem;
            border-radius: 10px;
            border: 1px solid;
            padding: 10px;
        }
    </style>

</head>
<body style="background-color: #dcdbe2">
<div class="container p-3 mb-2 bg-secondary text-white">
    <div class="container-fluid bg-light myBorder border-primary col-md">
        <form action="/encrypt/" method="post" onsubmit="return true">
            <div class="form-group">
                <p class="h4">ICM - Encryption Tool</p>
                <p>This is simple tool to encrypt your credentials.</p>
            </div>
            <div class="form-group">
                <input type="text" name="plainText" class="form-control"
                       placeholder="Enter your string." value="${fn:escapeXml(param.plainText)}"
                       required/>
            </div>
            <div class="form-group">
                <input type="text" name="encryptionKey" class="form-control"
                       placeholder="Enter a encryption key."
                       value="${fn:escapeXml(param.encryptionKey)}"
                       required/>
            </div>
            <div class="form-group">
                <button class="btn btn-info btn-block" type="submit"
                        onclick="form.action='/encrypt/';"> Encrypt
                </button>
                <button class="btn btn-primary btn-block" type="submit"
                        onclick="form.action='/decrypt/';"> Decrypt
                </button>
            </div>
        </form>
    </div>
    <div class="container-fluid bg-light myBorder">
        <label for="outputStringBox">
            <h4>Output String:</h4>
        </label>
        <input type="text" id="outputStringBox" class="md-textarea form-control"
               value="${result.outputString}">
    </div>
</div>
<footer class="py-4 bg-dark text-white-50"></footer>
</body>
</html>