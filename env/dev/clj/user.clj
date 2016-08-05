(ns user
  (:require [mount.core :as mount]
            albumbin.core))

(defn start []
  (mount/start-without #'albumbin.core/repl-server))

(defn stop []
  (mount/stop-except #'albumbin.core/repl-server))

(defn restart []
  (stop)
  (start))


