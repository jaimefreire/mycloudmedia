package mycloudmedia
class InfoController {
    def index = {
        [env: System.getenv()]
    }
}