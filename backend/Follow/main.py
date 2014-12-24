#!/usr/bin/env python
import webapp2, os, json
from google.appengine.ext.webapp import template

class BaseHandler(webapp2.RequestHandler):
  def render_template(self, view_filename, params={}):
    path = os.path.join(os.path.dirname(__file__), 'templates', view_filename)
    self.response.out.write(template.render(path, params))
  def render_json(self, dict):
    self.response.headers['Content-Type'] = 'application/json'
    self.response.out.write(json.dumps(dict))


class MainHandler(BaseHandler):
    def get(self):
      # self.render_template('index.html', {})
      self.render_json({'success': True})

app = webapp2.WSGIApplication([
    ('/', MainHandler)
], debug=True)