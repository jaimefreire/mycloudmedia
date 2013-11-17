package mycloudmedia
class InfoController {
    def index = {
        [test:"test",env: System.getenv()]

    }
}