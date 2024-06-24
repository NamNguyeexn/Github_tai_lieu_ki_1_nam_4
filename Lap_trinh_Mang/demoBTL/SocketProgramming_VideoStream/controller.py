from flask import Flask, redirect, url_for, render_template

app = Flask(__name__)

@app.route("/<name>")
def home(name):
    return render_template("home.html", content = name, r = 2)

# @app.route("/<name>")
# def user(name):
#     return f"Hello from {name}"

@app.route("/admin")
def admin():
    return redirect(url_for("home"))

if __name__ == "__main__" :
    app.run()