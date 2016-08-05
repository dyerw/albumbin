(ns albumbin.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [albumbin.layout :refer [error-page]]
            [albumbin.routes.user :refer [user-routes]]
            [compojure.route :as route]
            [albumbin.env :refer [defaults]]
            [mount.core :as mount]
            [albumbin.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    (-> #'user-routes
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
