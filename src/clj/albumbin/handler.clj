(ns albumbin.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [albumbin.routes.user :refer [user-routes]]
            [albumbin.routes.album :refer [album-routes]]
            [buddy.auth :refer [authenticated?]]
            [compojure.route :as route]
            [albumbin.env :refer [defaults]]
            [mount.core :as mount]
            [albumbin.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def auth-rules [{:uri "/album" :handler authenticated? :request-method :post}])

(def app-routes
  (routes
    album-routes
    (-> #'user-routes
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      {:status 404 :body {:error "not found"}})))


(defn app [] (middleware/wrap-base #'app-routes))
